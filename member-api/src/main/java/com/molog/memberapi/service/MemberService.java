package com.molog.memberapi.service;

import com.molog.memberapi.domain.*;
import com.molog.memberapi.repository.AddressRepository;
import com.molog.memberapi.repository.MemberRepository;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원 등록
    @Transactional
    public Long registerMember(MemberRegistrationReqDto memberRegistrationReqDto) {
        Address address = memberRegistrationReqDto.toAddressEntity();
        Long addressId = addressRepository.save(address);
        Address findAddress = addressRepository.findOne(addressId).orElseThrow(() ->
                new NoResultException("해당 주소를 찾을 수 없습니다."));
        // 비밀번호 암호화
        String encodedPw = passwordEncoder.encode(memberRegistrationReqDto.getMemberPw());
        Member member = memberRegistrationReqDto.toMemberEntity(encodedPw,findAddress);
        Long result = memberRepository.save(member);
        return result;
    }

    // 회원 정보 조회
    public MemberResDto getMemberInfo(Long memberId){
        Member findMember = memberRepository.findOne(memberId).orElseThrow(()->
                new IllegalArgumentException("해당 회원은 존재하지 않습니다."));
        MemberResDto result = MemberResDto.builder()
                .member(findMember).build();
        return result;
    }

    // 회원 검증
    public boolean validateMember(MemberLoginReq memberLoginReq) {
        Member findMember = memberRepository.findByMemberId(memberLoginReq.getMemberId()).orElseThrow(()->
                new NoResultException("해당 회원은 존재하지 않습니다."));
        if(passwordEncoder.matches(memberLoginReq.getMemberPw(), findMember.getMemberPw())){
            return true;
        }else{
            throw new IllegalArgumentException("비밀번호를 잘못 입력하였습니다.");
        }
    }
}
