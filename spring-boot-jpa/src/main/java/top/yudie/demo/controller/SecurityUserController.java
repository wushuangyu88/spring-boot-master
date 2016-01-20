package top.yudie.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import top.yudie.demo.jpa.entity.SecurityUser;
import top.yudie.demo.jpa.repo.SecurityUserRepo;

@RestController
@RequestMapping("/user")
public class SecurityUserController {
	@Resource
	SecurityUserRepo securityUserRepo;
	
	@RequestMapping("/list")
	public Iterable<SecurityUser> list(){
		return securityUserRepo.findAll();
	}
	
	/**
	 * 从请求url中取参数
	 * @param userCode
	 * @return
	 */
	@RequestMapping("/find/{userCode}")
	public SecurityUser find(@PathVariable String userCode){
		return securityUserRepo.findByuserCode(userCode);
	}
	
	/**
	 * 从url参数中取得参数，如/resetUserName?userCode=admin&userName=管理员
	 * @param userCode
	 * @param userName
	 * @return
	 */
	@RequestMapping("/resetUserName")
	public int resetUserName(@RequestParam(required=false)String userCode,
			@RequestParam(required=false)String userName){
		return securityUserRepo.updateUserNameByUserCode(userCode, userName);
	}
	
	/**
	 * 从url参数中取得参数，如/resetUserName?userCode=admin&userName=管理员
	 * @param userCode
	 * @param userName
	 * @return
	 */
	@RequestMapping("/resetUserPwdByUserNames")
	public int resetUserPwdByUserNames(@RequestParam(required=false)String userPwd,
			@RequestParam(required=false)String userNames){
		ArrayList<String> list = new ArrayList<String>();
		for(String name:userNames.split(",")){
			list.add(name);
		}
		return securityUserRepo.resetUserPwdByUserNames(list, userPwd);
	}
}
