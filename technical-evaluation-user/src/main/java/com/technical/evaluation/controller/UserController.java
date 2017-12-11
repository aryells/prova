package com.technical.evaluation.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.technical.evaluation.domain.User;
import com.technical.evaluation.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<HttpHeaders> create(@RequestBody User user) {
		User userSaved = this.service.save(user);
		if(userSaved == null) return ResponseEntity.noContent().build();
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(userSaved.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping
	public ResponseEntity<List<User>> all() {
		return ResponseEntity.ok(this.service.all());
	}

	@GetMapping(value = "/-{id}")
	public ResponseEntity<User> get(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.get(id));
	}

	@GetMapping(value = "/{cpf}")
	public ResponseEntity<User> get(@PathVariable("cpf") String cpf) {
		return ResponseEntity.ok(this.service.get(cpf));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> edit(@PathVariable("id") Long id, @RequestBody User user) {
		return ResponseEntity.ok(this.service.save(user));
	}
	
}
