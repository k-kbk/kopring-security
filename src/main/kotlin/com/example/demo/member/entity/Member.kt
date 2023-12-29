package com.example.demo.member.entity

import com.example.demo.common.status.Gender
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import jakarta.persistence.UniqueConstraint
import java.time.LocalDate

@Entity
@Table(
    uniqueConstraints = [UniqueConstraint(
        name = "uk_member_login_id",
        columnNames = ["loginId"]
    )]
)
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = 0L,

    @Column(nullable = false, length = 30, updatable = false)
    val loginId: String,

    @Column(nullable = false, length = 100)
    val password: String,

    @Column(nullable = false, length = 10)
    val name: String,

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    val birthDate: LocalDate,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val gender: Gender,

    @Column(nullable = false, length = 30)
    val email: String,
) {

    companion object {
        fun of(
            loginId: String,
            password: String,
            name: String,
            birthDate: LocalDate,
            gender: Gender,
            email: String
        ): Member {
            return Member(
                loginId = loginId,
                password = password,
                name = name,
                birthDate = birthDate,
                gender = gender,
                email = email
            )
        }
    }
}