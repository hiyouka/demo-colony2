package com.jy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈〉
 *
 * @author jianglei
 * @create 2018/6/29
 * @since 1.0.0
 */
@RestController
public class JobTest {

    private Logger logger = LoggerFactory.getLogger(JobTest.class);

    @RequestMapping(value = "/jobTest",method = RequestMethod.GET)
    public String simpleJob(){
        logger.info("{} job start",new Exception().getStackTrace()[0].getMethodName());
        logger.info("job start time :{}" ,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return "ok";
    }

}