package com.bankaccount.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bankaccount.domain.Client;
import com.bankaccount.services.client.CreateClientService;
import com.bankaccount.services.client.ListClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientsResource {
	// index, show, create, update, delete
	@Autowired
	private CreateClientService createClientService;

	@Autowired
	private ListClientService listClientService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Client>> index() {
		return ResponseEntity.status(HttpStatus.OK).body(listClientService.execute());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestBody Client client) {
		client = createClientService.execute(client);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
}
