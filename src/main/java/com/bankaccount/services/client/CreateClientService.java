package com.bankaccount.services.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaccount.domain.Client;
import com.bankaccount.repository.ClientsRepository;

@Service
public class CreateClientService {
	@Autowired
	private ClientsRepository clientRepository;
	
	public Client execute(Client client) {
		client.setId(null);
		
		return clientRepository.save(client);
	}
}
