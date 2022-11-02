package com.hazelcast.spring.cache.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hazelcast.spring.cache.application.model.User;
import com.hazelcast.spring.cache.application.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/cache")
public class UserController {

	@Autowired
	private UserService service;

	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() throws JsonProcessingException {
		List<User> userList = service.getUsers();	
		return  new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<List<User>> getUser(@PathVariable int id) {
		List<User> userList = service.getUser(id);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.delete(id);
	}

}
