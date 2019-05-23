package com.example.demo.Controller;

import com.example.demo.entity.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/5/23
 * @mail jiangbo.ge@kuwo.cn
 */
@RestController
@RequestMapping("/jsonp")
public class JsonpTestController {
    @RequestMapping(value = "/testJsonp",produces = MediaType.APPLICATION_JSON_VALUE)
    public Student testJsonp(){
        Student student = new Student();
        student.setId("1");
        student.setName("durk");
        student.setSex("man");
        return student;
    }
}
