package org.stud.base.realm;

import java.util.Arrays;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.stud.base.permission.BitPermission;

/**
 * @author zhangfeng542
 * @date 5/6/19
 */
public class AuthorizerRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		simpleAuthorizationInfo.addRoles(Arrays.asList("role1","role2"));

		simpleAuthorizationInfo.addObjectPermissions(Arrays.asList(new BitPermission("+user1+10"),new WildcardPermission("user1:*")));
		simpleAuthorizationInfo.addStringPermissions(Arrays.asList("+user2+8","user2:*"));

		return simpleAuthorizationInfo;
	}



	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
		throws AuthenticationException {
		BaseRealm baseRealm = new BaseRealm();
		return baseRealm.getAuthenticationInfo(authenticationToken);
	}
}
