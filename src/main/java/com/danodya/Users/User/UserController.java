package com.danodya.Users.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET,value="/users")
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/users/{id}")
	public Optional<Users> getUser(@PathVariable int id){
		return userService.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody Users user){
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}")
	public void updateUser(@RequestBody Users user,@PathVariable int id){
		userService.updateUser(user,id);
	}
	
	@RequestMapping(method=RequestMethod.PATCH, value="/users/{id}")
	public void patchUser(@RequestBody Users user, @PathVariable int id) {
		userService.patchUser(user,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable int id){
		userService.deleteUser(id);
	}
}
