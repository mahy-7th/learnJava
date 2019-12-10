package com.hbz.module.index.controller;

import com.hbz.module.index.entity.User;
import com.hbz.module.index.entity.Users;
import com.hbz.module.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author mahy
 * @Time 2019-12-05 14:25
 * @Describe : 访问首页的控制器
 */
@Controller
@RequestMapping("/access")
public class AccessIndexController {

	@Autowired
	private IndexService indexService;

	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@RequestMapping("/other")
	public String other(){
		return "other/other";
	}

	@RequestMapping("/getGlobal")
	@ResponseBody
	public String getGlobal(){
		List<Users> list = indexService.listUsers();
		return list.toString();
	}

	@RequestMapping("/getFramework")
	@ResponseBody
	public String getFramework(){
		List<User> users = indexService.listUser();
		return users.toString();
	}





}
