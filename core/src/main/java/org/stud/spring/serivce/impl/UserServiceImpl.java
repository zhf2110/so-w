package org.stud.spring.serivce.impl;

import java.util.Set;
import org.stud.spring.domian.User;
import org.stud.spring.serivce.UserService;

/**
 * @author zhangfeng542
 * @date 5/7/19
 */
public class UserServiceImpl implements UserService{

	@Override
	public User createUser(User user) {
		return null;
	}

	@Override
	public void changePassworld(Long userID, String newPassword) {

	}

	@Override
	public void correlationRoles(Long userID, Long... roleIDs) {

	}

	@Override
	public void uncorrelationRoles(Long userID, Long... roleIDs) {

	}

	@Override
	public User findByUserName(String username) {
		return null;
	}

	@Override
	public Set<String> findRoles(String username) {
		return null;
	}

	@Override
	public Set<String> findPermission(String username) {
		return null;
	}
}
