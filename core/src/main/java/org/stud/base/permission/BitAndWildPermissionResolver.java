package org.stud.base.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * 将字符串转为对应的权限
 * @author zhangfeng542
 * @date 5/6/19
 */
public class BitAndWildPermissionResolver implements PermissionResolver {

	@Override
	public Permission resolvePermission(String s) {
		if(s.startsWith("+")){
			return new BitPermission(s);
		}
		return new WildcardPermission(s);
	}
}
