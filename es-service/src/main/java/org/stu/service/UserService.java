package org.stu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stu.domain.User;
import org.stu.mapper.UserMapper;

/**
 * @author zhangfeng542
 * @date 5/9/19
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;


	public List<User> allUserInfo(){
		return userMapper.selectList(null);
	}

}
