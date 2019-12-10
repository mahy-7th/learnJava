package com.hbz.module.index.service;

import com.hbz.module.index.entity.User;
import com.hbz.module.index.entity.Users;

import java.util.List;

/**
 * @Author mahy
 * @Time 2019-12-05 16:04
 * @Describe : Here is the description
 */
public interface IndexService {


	List<Users> listUsers();

	List<User> listUser();



}
