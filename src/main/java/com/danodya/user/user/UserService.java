package com.danodya.user.user;

import java.util.List;

public interface UserService {

	List<Users> getAllUsers();
	
	Users getUser(int id);
	
	void addUser(Users user);
	
	void updateUser(Users user, int id);
	
	void patchUser(Users user, int id);
	
	void deleteUser(int id);
	
}
