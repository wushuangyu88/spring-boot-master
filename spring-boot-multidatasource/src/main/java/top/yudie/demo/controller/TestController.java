package top.yudie.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.yudie.demo.jpa.test.entity.User;
import top.yudie.demo.jpa.test.repo.UserRepo;

@RestController
@RequestMapping("test")
public class TestController {
	@Resource
	UserRepo userRepo;

	@RequestMapping("list")
	public Iterable<User> list() {
		return userRepo.findAll();
	}
}
