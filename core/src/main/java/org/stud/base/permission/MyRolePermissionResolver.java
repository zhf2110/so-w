package org.stud.base.permission;

import java.util.Arrays;
import java.util.Collection;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * @author zhangfeng542
 * @date 5/6/19
 */
public class MyRolePermissionResolver implements RolePermissionResolver{

	@Override
	public Collection<Permission> resolvePermissionsInRole(String s) {

		if("role1".equals(s)){
			return Arrays.asList((Permission) new WildcardPermission("menu:*"));
		}

		return null;
	}
}
