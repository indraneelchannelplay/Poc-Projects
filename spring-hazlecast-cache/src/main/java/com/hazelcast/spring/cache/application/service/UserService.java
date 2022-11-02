package com.hazelcast.spring.cache.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hazelcast.spring.cache.application.dao.UserRepository;
import com.hazelcast.spring.cache.application.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Cacheable(cacheNames = { "userCache" })
	public List<User> getUsers() {
		System.out.println("Hit DB 1st time in getUsers()");
		return repository.getUsers();
	}

	@Cacheable(value = "userCache", key = "#id", unless = "#result==null")
	public List<User> getUser(int id) {
		System.out.println("Hit HazelCast Cache 1st time in getUser()");
		return repository.getUserById(id);
	}

	@CacheEvict(value = "userCache")
	public String delete(int id) {
		repository.deleteById(id);
		return "User deleted with id " + id;
	}

}
