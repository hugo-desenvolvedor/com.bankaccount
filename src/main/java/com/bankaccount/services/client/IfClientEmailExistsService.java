package com.bankaccount.services.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaccount.domain.Client;
import com.bankaccount.repository.ClientsRepository;

@Service
public class IfClientEmailExistsService {
	@Autowired
	private ClientsRepository clientRepository;
	
	public Boolean execute(String email) {
		List<Client> responseEmail = clientRepository.findByEmail(email);
		
		return responseEmail.isEmpty() ? false : true;
	}
}
