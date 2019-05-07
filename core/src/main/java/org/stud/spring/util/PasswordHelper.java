package org.stud.spring.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.stud.spring.domian.User;

/**
 * @author zhangfeng542
 * @date 5/7/19
 */
public class PasswordHelper {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private String alogrithm = "MD5";

	private final int hashIter = 2;

	public void encrypPassword(User user){

		String salt = randomNumberGenerator.nextBytes().toBase64();

		String code = new SimpleHash(alogrithm,user.getPassword(),salt,hashIter).toBase64();

		user.setPassword(code);
	}

}
