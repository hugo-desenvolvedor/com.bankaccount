package com.bankaccount.services.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaccount.domain.Client;
import com.bankaccount.repository.ClientsRepository;
import com.bankaccount.services.exceptions.CpfAlreadyExistsException;
import com.bankaccount.services.exceptions.EmailAlreadyExistsException;

@Service
public class CreateClientService {
	@Autowired
	private ClientsRepository clientRepository;
	
	public Client execute(Client client) {
		List<Client> email = clientRepository.findByEmail(client.getEmail());
		if (!email.isEmpty()) {
			throw new EmailAlreadyExistsException();
		}
		
		List<Client> cpf = clientRepository.findByCpf(client.getCpf());
		if (!cpf.isEmpty()) {
			throw new CpfAlreadyExistsException();
		}
		
		client.setId(null);
		
		return clientRepository.save(client);
	}
}
