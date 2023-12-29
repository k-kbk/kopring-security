package com.example.demo.member.controller

import com.example.demo.member.dto.SignUpRequest
import com.example.demo.member.service.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/member")
@RestController
class MemberController(
    private val memberService: MemberService
) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): String {
        return memberService.signup(signUpRequest)
    }
}