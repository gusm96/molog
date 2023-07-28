package com.molog.memberapi.controller;

import com.molog.memberapi.domain.MemberRegistrationReqDto;
import com.molog.memberapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/v1/member")
     public ResponseEntity<Long> registerMember(MemberRegistrationReqDto memberRegistrationReqDto){
        Long resultId = memberService.registerMember(memberRegistrationReqDto);
        return ResponseEntity.ok().body(resultId);
    }
}
