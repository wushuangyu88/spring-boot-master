package top.yudie.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.yudie.demo.jpa.entity.User;
import top.yudie.demo.jpa.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	UserRepo userRepo;
	
	@RequestMapping("/list")
	public Iterable<User> list(){
		return userRepo.findAll();
	}
	
	@RequestMapping("/create")
	public User create(@RequestParam String userName){
		User user = new User();
		user.setUserName(userName);
		return userRepo.save(user);
	}
}
