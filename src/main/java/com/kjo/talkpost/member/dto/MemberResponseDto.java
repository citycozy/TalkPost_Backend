package com.kjo.talkpost.member.dto;

import lombok.*;

public class MemberResponseDto {

  @Getter
  @Builder
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @AllArgsConstructor(access = AccessLevel.PROTECTED)
  public static class SignUpResponse {
    String email;
    String nickName;
  }
}