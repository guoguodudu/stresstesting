package com.stress.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service {

    //@Autowired
    //private IStudentService iStudentService;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void getRedis(){
        redisTemplate.boundZSetOps("1");
        redisTemplate.boundGeoOps("123");

        System.out.println(redisTemplate);
    }
}

