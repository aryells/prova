package com.technical.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technical.evaluation.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findOneByCpf(String cpf);
	
}
