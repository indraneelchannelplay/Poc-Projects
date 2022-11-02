package com.hazelcast.spring.cache.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hazelcast.spring.cache.application.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(
			  value = "SELECT * FROM orosoft_employee ", 
			  nativeQuery = true)
	List<User> getUsers();

	@Query(
			  value = "SELECT * FROM orosoft_employee where id = ?1", 
			  nativeQuery = true)
	List<User> getUserById(int id);
}
