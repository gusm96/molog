package com.molog.memberapi.repository;

import com.molog.memberapi.domain.Member;

import java.util.Optional;

public interface MemberRepositoryInf {
    Long save(Member member);
    Optional<Member> findOne (Long id);

    Optional<Member> findByMemberId(String MemberId);
}
