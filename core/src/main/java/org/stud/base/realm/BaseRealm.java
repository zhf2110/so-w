package org.stud.base.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

/**
 * @author zhangfeng542
 * @date 5/6/19
 */
public class BaseRealm implements Realm{

	@Override
	public String getName() {
		return "baseRealm";
	}

	/**
	 * 此realm是否支持此token
	 * @param authenticationToken
	 * @return
	 */
	@Override
	public boolean supports(AuthenticationToken authenticationToken) {
		return authenticationToken instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken)
		throws AuthenticationException {

		//用户名
		String username = (String)authenticationToken.getPrincipal();
		//登录密码
		String password = new String((char[]) authenticationToken.getCredentials());

		if(!"zhang".equals(username)){
			throw new UnknownAccountException();
		}

		if(!"123".equals(password)){
			throw new IncorrectCredentialsException();
		}
		//AuthenticationInfo用来在多个认证策略之间传递数据
		return new SimpleAuthenticationInfo(username,password,getName());
	}
}
