package com.hbz.module.index.service.impl;

import com.hbz.module.index.dao.framework.TestDao;
import com.hbz.module.index.entity.User;
import com.hbz.module.index.entity.Users;
import com.hbz.module.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author mahy
 * @Time 2019-12-05 16:05
 * @Describe : Here is the description
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {

	@Autowired
	private TestDao testDaoF;

	@Autowired
	private com.hbz.module.index.dao.global.TestDaoGlobal testDaoG;


	@Override
	public List<Users> listUsers() {
		return testDaoG.listUsers();
	}

	@Override
	public List<User> listUser() {
		return testDaoF.listUser();
	}
}
