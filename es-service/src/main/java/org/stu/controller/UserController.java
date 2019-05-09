package org.stu.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stu.domain.Result;
import org.stu.domain.User;
import org.stu.service.UserService;

/**
 * @author zhangfeng542
 * @date 5/9/19
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/allInfo")
	public Result<List<User>> allInfo(){
		logger.info("/user/allInfo");
        Result<List<User>> result = null;
		try {
			List<User> users = userService.allUserInfo();
			result = new Result(users);
		} catch (Exception e) {
			logger.error("query user info is err.",e);
			result = new Result<List<User>>("0001","query all info is err");
		}
		return result;
	}


}
