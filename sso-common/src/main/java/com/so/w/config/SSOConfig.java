package com.so.w.config;


import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangfeng542
 * @date 5/14/19
 */
@Configuration
public class SSOConfig {

	@Bean
	public DefaultWebSecurityManager securityManager(){
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

		return manager;
	}

}
