package com.bankaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankaccount.domain.Client;

public interface ClientsRepository extends JpaRepository<Client, Long> {

}
