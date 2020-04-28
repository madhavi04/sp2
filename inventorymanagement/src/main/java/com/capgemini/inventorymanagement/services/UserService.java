package com.capgemini.inventorymanagement.services;

import java.util.List;

import com.capgemini.inventorymanagement.entities.Userdata;	

public interface UserService
{
	Userdata addUser(Userdata u);
	
	List<Userdata>getAllUsers();
	
	Userdata deleteUser(int userId);
	
	Userdata updateUser(Userdata u);
	
	Boolean loginUser(Userdata u);
}
