package com.hbz.module.index.dao.framework;

import com.hbz.module.index.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author mahy
 * @Time 2019-12-05 15:54
 * @Describe : 测试framework库
 */
@Repository
public interface TestDao {

	List<User> listUser();

}
