package com.stress.test.mapper;

import com.stress.test.domain.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface StudentMapper extends Mapper<Student> {
}