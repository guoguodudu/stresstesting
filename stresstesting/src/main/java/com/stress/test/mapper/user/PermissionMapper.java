package com.stress.test.mapper.user;

import com.stress.test.domain.user.Permission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface PermissionMapper extends Mapper<Permission> {
    List<Permission> findByUserPermission(Long userId);
}