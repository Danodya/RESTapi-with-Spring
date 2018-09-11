package com.danodya.user.user;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Users getUser(@PathVariable int id){
		return userService.getUser(id);
	}
	
	@PostMapping
	public void addUser(@RequestBody Users user){
		userService.addUser(user);
	}
	
	@PutMapping("/{id}")
	public void updateUser(@RequestBody Users user,@PathVariable int id){
		userService.updateUser(user,id);
	}
	
	@PatchMapping("/{id}")
	public void patchUser(@RequestBody Users user, @PathVariable int id) {
		userService.patchUser(user,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id){
		userService.deleteUser(id);
	}
}
