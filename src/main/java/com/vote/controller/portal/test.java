package com.vote.controller.portal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2017/11/19.
 */
@RestController
@RequestMapping("/test")
public class test {

    @RequestMapping(value = "/hello.do", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }
}
