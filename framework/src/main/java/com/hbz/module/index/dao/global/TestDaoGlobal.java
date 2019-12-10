package com.hbz.module.index.dao.global;

import com.hbz.module.index.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author mahy
 * @Time 2019-12-05 15:55
 * @Describe : 测试Gaobal库
 */
@Repository
public interface TestDaoGlobal {

	List<Users> listUsers();
}
