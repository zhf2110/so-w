package org.stud.base.encode;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangfeng542
 * @date 5/6/19
 */
public class BaseEncode {

	private final static Logger LOGGER = LoggerFactory.getLogger(BaseEncode.class);

	/**
	 * shior支持base64和16进制
	 */
	public void encode(){
		String code = Base64.encodeToString("hello".getBytes());
		LOGGER.info("编码后结果为:{}",code);
		LOGGER.info("解码后的结果为:{}",Base64.decodeToString(code));

		String hex = Hex.encodeToString("world".getBytes());
		LOGGER.info("十六进制编码后为：{}",hex);
		LOGGER.info("十六进制解码后为：{}",new String(Hex.decode(hex)));
	}

	public static void hash(String paw,String salt){
		String result = new Md5Hash(paw,salt).toString();
		LOGGER.info("md5加密后结果为：{}",result);

		String sh256 = new Sha256Hash(paw,salt).toString();
		LOGGER.info("sha256加密后结果为：{}",sh256);

		SecureRandomNumberGenerator randomNumberGenerator =
			new SecureRandomNumberGenerator();
		randomNumberGenerator.setSeed("123".getBytes());
		String hex = randomNumberGenerator.nextBytes().toHex();
		LOGGER.info("生成随机数为：{}",hex);
	}

	public static void main(String[] args) {

		hash("hell","world");

	}

}
