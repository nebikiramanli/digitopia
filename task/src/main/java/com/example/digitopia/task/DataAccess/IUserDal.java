package com.example.digitopia.task.DataAccess;

import java.util.List;

import com.example.digitopia.task.Entities.User;

public interface IUserDal {
	User getById(int id);
	void add(User user);
	void update (User user);
	void delete (User user);
	List<User> getUsersByNormalizedName(String normalizedName);
	User getUserByEmail(String email);
	
	// Organizyonları dönen bir metot 
	/*
	 * Organization getOrganizations(userId){
	 * 
	 * }
	 */
	
	
}
