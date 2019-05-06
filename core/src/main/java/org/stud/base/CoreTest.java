package org.stud.base;

import java.util.Arrays;
import java.util.Set;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangfeng542
 * @date 5/6/19
 */
public class CoreTest {

	private final static Logger LOGGER = LoggerFactory.getLogger(CoreTest.class);

	static{
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager manager = factory.getInstance();
		SecurityUtils.setSecurityManager(manager);
	}

	/**
	 * 认证
	 */
	public static void login(String username,String password){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}

		PrincipalCollection conllection = subject.getPrincipals();
		LOGGER.info("身份验证的集合长度为：{}",conllection.asList().size());

		Set<String> realms = conllection.getRealmNames();

		for(String realm : realms){
			LOGGER.info("认证数据域的名称为：{}",realm);
		}


		/*if(subject.isAuthenticated()){
			LOGGER.info("已认证退出");
			subject.logout();
		}*/
	}


	/**
	 * 授权
	 */
	public static void shouquan(){

		Subject subject = SecurityUtils.getSubject();
		login("zhang","123");

		LOGGER.info("用户是否role1角色[{}]",subject.hasRole("role1"));
		LOGGER.info("用户是否是role1,role3角色[{}]",subject.hasRoles(Arrays.asList("role1","role3")));

		LOGGER.info("用户是否拥有user:create权限[{}]",subject.isPermitted("user1:create"));
		LOGGER.info("用户是否拥有user:delete权限[{}]",subject.isPermitted("user1:delete"));
	}

	public static void main(String[] args) {
        shouquan();
	}


}
