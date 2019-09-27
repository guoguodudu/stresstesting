package com.stress.test.controller;

import com.fenyun.base.base.response.BaseController;
import com.fenyun.base.base.response.RestResponse;
import com.stress.test.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stu/")
public class StudentController extends BaseController {

    @Autowired
    private IStudentService iStudentService;


    @RequestMapping("add")
    public RestResponse UserTest(){
        return insertResponse(iStudentService.insertStudent());
    }

    @RequestMapping("userList")
    public RestResponse queryUserTest(){
        return successResponse(iStudentService.queryStudent());
    }
}
