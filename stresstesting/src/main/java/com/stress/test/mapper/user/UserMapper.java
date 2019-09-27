package com.stress.test.mapper.user;

import com.stress.test.domain.user.Role;
import com.stress.test.domain.user.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    User findByUserName(String UserLogin);
}