package com.example.eurekaclientcustomer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangfeng542 on 2019/5/21.
 */
@RestController
public class CustomerController {


    @GetMapping("getMapper")
    public String getMapper(){
        return "heool";
    }


    @GetMapping("queryData")
    public Map<String,String> queryData(){
        Map<String,String> map = new HashMap<>();
        map.put("zf","zhangsan");
        map.put("zfu","zhangfugui");
        return map;
    }

}
