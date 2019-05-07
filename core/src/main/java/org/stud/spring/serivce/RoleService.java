package org.stud.spring.serivce;

import org.stud.spring.domian.Role;

/**
 * @author zhangfeng542
 * @date 5/6/19
 */
public interface RoleService {

	Role createRole(Role role);

	void deleteRole(Long roleID);

	void correlationPermission(Long roleID,Long ... permissionIDs);

	void uncorrelationPermission(Long roleID,Long ... permissionIDs);

}
