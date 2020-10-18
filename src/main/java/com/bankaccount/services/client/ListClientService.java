package com.bankaccount.services.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaccount.domain.Client;
import com.bankaccount.repository.ClientsRepository;

@Service
public class ListClientService {
	@Autowired
	private ClientsRepository clientRepository;
	
	public List<Client> execute() {
		return clientRepository.findAll();
	}
}
