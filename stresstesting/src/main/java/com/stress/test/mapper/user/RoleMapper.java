package com.stress.test.mapper.user;

import com.stress.test.domain.user.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface RoleMapper extends Mapper<Role> {

    List<Role> findByUserRole(Long userId);


}