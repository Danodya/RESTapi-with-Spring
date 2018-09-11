package com.danodya.Users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<Users> getAllUsers(){
		List<Users> users = new ArrayList<>();
		usersRepository.findAll()
		.forEach(users::add);
		return users;

	}
	

	@Override
	public Users getUser(int id) {

		Optional<Users> users = usersRepository.findById(id);

		Users u = null;
		if (users.isPresent()) {
			u = users.get();
		}
		return u;
	}

	@Override
	public void addUser(Users user) {
		usersRepository.save(user);
		
	}

	@Override
	public void updateUser(Users user, int id) {
				
			Optional<Users> users = usersRepository.findById(id);
			if(users.isPresent()) {
				Users u =users.get();
				if((!u.getName().equals(user.getName())) && (u.getAge() != user.getAge())) {
					usersRepository.save(user);
				}
				
			}
			
		}
	
	@Override
	public void deleteUser(int id) {
		
		usersRepository.deleteById(id);
	}
	
	@Override
	public void patchUser(Users user, int id) {
		if(usersRepository.existsById(id)) {
			
			usersRepository.save(user);
		}
		
	}



}
