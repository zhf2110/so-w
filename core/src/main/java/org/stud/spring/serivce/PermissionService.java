package org.stud.spring.serivce;

import org.apache.shiro.authz.Permission;

/**
 * @author zhangfeng542
 * @date 5/6/19
 */
public interface PermissionService {

	Permission create(Permission permission);

	void deletePermission(Long permissionID);

}
