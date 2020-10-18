package com.bankaccount.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bankaccount.domain.Address;
import com.bankaccount.services.address.CreateAddressService;

@RestController
@RequestMapping(value = "/clients/{id}/address")
public class AddressesResource {
	// index, show, create, update, delete
	@Autowired
	private CreateAddressService createAddressService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@PathVariable("id") Long clientId, @Valid @RequestBody Address address) {
		address = createAddressService.execute(clientId, address);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/clients/{id}").buildAndExpand(clientId).toUri();

		return ResponseEntity.created(uri).build();
	}
}
