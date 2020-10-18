package com.bankaccount.services.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankaccount.domain.Address;
import com.bankaccount.domain.Client;
import com.bankaccount.repository.AddressesRepository;
import com.bankaccount.repository.ClientsRepository;
import com.bankaccount.services.exceptions.ClientNotFoundException;

@Service
public class CreateAddressService {
	@Autowired
	private AddressesRepository addressRepository;

	@Autowired
	private ClientsRepository clientRepository;

	public Address execute(Long clientId, Address address) {
		Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException());

		address.setId(null);
		address.setClient(client);

		return addressRepository.save(address);
	}
}
