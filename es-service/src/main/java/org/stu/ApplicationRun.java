package org.stu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangfeng542
 * @date 5/9/19
 */
@MapperScan("org.stu.mapper")
@SpringBootApplication
public class ApplicationRun {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRun.class,args);
	}

}
