package org.stud.spring.serivce;

import java.util.Set;
import org.stud.spring.domian.User;

/**
 * @author zhangfeng542
 * @date 5/6/19
 */
public interface UserService {

	User createUser(User user);

	void changePassworld(Long userID,String newPassword);

	void correlationRoles(Long userID,Long ... roleIDs);

	void uncorrelationRoles(Long userID,Long ... roleIDs);

	User findByUserName(String username);

	Set<String> findRoles(String username);

	Set<String> findPermission(String username);

}
