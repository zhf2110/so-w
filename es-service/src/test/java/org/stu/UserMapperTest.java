package org.stu;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.stu.domain.User;
import org.stu.mapper.UserMapper;

/**
 * @author zhangfeng542
 * @date 5/9/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

	@Autowired
	private UserMapper userMapper;

	@Test
	public void selectUser(){
		List<User> us = userMapper.selectList(null);

		for(User u : us){
			LOGGER.info("对象内容为：{}",u.getName());
		}
	}

}
