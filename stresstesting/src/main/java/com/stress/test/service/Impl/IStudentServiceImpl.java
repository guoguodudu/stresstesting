package com.stress.test.service.Impl;

import com.stress.test.domain.Student;
import com.stress.test.mapper.StudentMapper;
import com.stress.test.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class IStudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int insertStudent() {

        log.info("methed=insertStudent");

        Student student=new Student();;
         student=new Student();
        student.setId(null);
        student.setString(null);
        student.setName(null);
        student.setAddress("3");
        studentMapper.insert(student);

        int i = 0;
        return i;
    }

    @Override
    public List<Student> queryStudent() {

        log.info("methed=queryStudent");


        return studentMapper.selectAll();
    }

    @Override
    public void queryStudentRedis() {
    }
}
