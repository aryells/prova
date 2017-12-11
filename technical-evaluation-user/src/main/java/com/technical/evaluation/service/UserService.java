package com.technical.evaluation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical.evaluation.domain.User;
import com.technical.evaluation.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public List<User> all() {
		return repository.findAll();
	}
	
	public User get(Long id) {
		return repository.findOne(id);
	}
	
	public User get(String cpf) {
		return repository.findOneByCpf(cpf);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
	
}
