package com.example.eurekaclientproduce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangfeng542 on 2019/5/21.
 */
@RestController
public class ProduceController {

    private final Logger logger = LoggerFactory.getLogger(ProduceController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("getInfo")
    public String getInfo(){

        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-CLIENT-PRODUCE");

        if(instances == null){
            logger.info("the discovery instance is null.");
            return "null";
        }

        logger.info("{}",instances.size());

        for(ServiceInstance instance : instances){
            Map<String,String> data = instance.getMetadata();
            data.forEach((k,v)->{
                logger.info("k :{}, v : {}",k,v);
            });
            logger.info(" host : {}, {}",instance.getHost(),instance.getUri().toString());
        }

        String url = "http://localhost:8200/getMapper";
        String result = restTemplate.getForObject(url,String.class);
        return result;
    }

    @GetMapping("queryUser")
    public Map<String,String> queryUser(){

        String url = "http://localhost:8200/queryData";

        Map<String,String> result = restTemplate.getForEntity(url,Map.class).getBody();

        return result;
    }

}
