package com.bankaccount.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankaccount.domain.Client;

@Repository
public interface ClientsRepository extends JpaRepository<Client, Long> {
	List<Client> findByEmail(String email);
	List<Client> findByCpf(String cpf);
}
