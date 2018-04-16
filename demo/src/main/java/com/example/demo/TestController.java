package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangsen
 * @data 2018/4/10 9:42
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/testGet")
    public Object getTest(){
        return "testget";
    }
}
