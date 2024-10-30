package com.kjo.talkpost.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.kjo.talkpost.entity.SocialType;
import com.kjo.talkpost.member.dto.MemberRequestDto.*;
import com.kjo.talkpost.member.dto.MemberResponseDto.*;
import com.kjo.talkpost.member.entity.Member;
import com.kjo.talkpost.member.entity.valid.Email;
import com.kjo.talkpost.member.entity.valid.Password;

@Component
public class MemberConverter {

  public static Member toMember(SignUpRequest req) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    return Member.builder()
        .email(Email.validateEmail(req.getEmail()))
        .nickname(req.getNickname())
        .password(Password.encrypt(req.getPassword(), encoder))
        .socialType(SocialType.EMAIL)
        .build();
  }

  public static SignUpResponse toSignUpResponse(Member member) {
    return SignUpResponse.builder()
        .nickName(member.getNickname())
        .email(member.getEmail().getValidatedEmail())
        .build();
  }
}