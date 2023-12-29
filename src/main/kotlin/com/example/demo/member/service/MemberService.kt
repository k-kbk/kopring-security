package com.example.demo.member.service

import com.example.demo.member.dto.SignUpRequest
import com.example.demo.member.entity.Member
import com.example.demo.member.repository.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun signup(signUpRequest: SignUpRequest): String {
        memberRepository.findByLoginId(signUpRequest.loginId)
            ?.let {
                throw IllegalArgumentException("아이디 중복")
            }
        val member = with(signUpRequest) {
            Member.of(loginId, password, name, birthDate, gender, email)
        }
        memberRepository.save(member)

        return "회원가입 성공"
    }
}