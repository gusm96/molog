package com.molog.memberapi.repository;

import com.molog.memberapi.domain.Address;

import java.util.Optional;

public interface AddressRepositoryInf {
    Long save(Address address);

    Optional<Address> findOne(Long id);
}
