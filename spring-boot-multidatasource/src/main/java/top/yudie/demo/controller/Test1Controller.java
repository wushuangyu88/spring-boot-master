package top.yudie.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.yudie.demo.jpa.test1.entity.User;
import top.yudie.demo.jpa.test1.repo.UserRepo;

@RestController
@RequestMapping("test1")
public class Test1Controller {
	@Resource
	UserRepo userRepo;
	
	@RequestMapping("list")
	public Iterable<User> list() {
		return userRepo.findAll();
	}
	
}
