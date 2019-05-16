package org.stud.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangfeng542
 * @date 5/16/19
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

	@RequestMapping("/")
	@ResponseBody
	public String index(){
		return "test";
	}

}
