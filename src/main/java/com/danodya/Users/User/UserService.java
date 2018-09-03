package com.danodya.Users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.lang.model.element.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private Userstuples usersTuples;
	
//	private List<Users> users = new ArrayList<>(Arrays.asList(
//			new Users(1,"Kasun",24),
//			new Users(2,"Chamalka",23),
//			new Users(3,"shanilka",23)));

	public List<Users> getAllUsers() {
		
		List<Users> users = new ArrayList<>();
		usersRepository.findAll()
		.forEach(users::add);
		return users;
	}

	public Optional<Users> getUser(int id) {
		//String i = Integer.toString(id);
		//return (Users) users.stream().filter(t -> t.getId()==id).findFirst().get();
		return usersRepository.findById(id);
	}

	public void addUser(Users user) {
		usersRepository.save(user);
		
	}
 
	public void updateUser(Users user, int id) {
		
//	for(int i=0; i<users.size(); i++) {
//			
//			Users u = users.get(i);
//			if(u.getId()==id) {
//				users.set(i,user);
//			}
//		}
		
//		if(usersRepository.existsById(id)) {
//		
//			usersTuples.getElements().
//			
//		
//		}
		usersRepository.save(user);
	}
	
	

	public void deleteUser(int id) {
//		users.removeIf(t -> t.getId()==id);
		usersRepository.deleteById(id);
	}

	public void patchUser(Users user, int id) {
		if(usersRepository.existsById(id)) {
			
			usersRepository.save(user);
		}
		
	}


}
