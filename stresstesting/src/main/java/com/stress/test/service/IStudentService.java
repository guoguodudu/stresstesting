package com.stress.test.service;

import com.fenyun.base.base.exception.ServiceException;
import com.stress.test.domain.Student;

import java.util.List;

public interface IStudentService {
    int insertStudent() throws ServiceException;

    List<Student> queryStudent();

    void queryStudentRedis();

}
