package com.bankaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankaccount.domain.Address;

public interface AddressesRepository extends JpaRepository<Address, Long> {

}


