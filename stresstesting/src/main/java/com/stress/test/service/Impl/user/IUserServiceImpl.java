package com.stress.test.service.Impl.user;

import com.stress.test.domain.user.User;
import com.stress.test.mapper.user.RoleMapper;
import com.stress.test.mapper.user.UserMapper;
import com.stress.test.service.user.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Slf4j
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

   // @Autowired
   // private BaseRoleMapper baseRoleMapper;

    @Override
    public int insertUser(User user) {
        log.info("method=insertUser,user=【{}】",user);

        System.out.println(roleMapper.findByUserRole(1L));

        System.out.println(roleMapper.selectAll());

       // List<Role> role=roleMapper.findByUserRole2(1L);

        //System.out.println(roleMapper.findByUserRole2(1L));


       // System.out.println(baseRoleMapper.findByUserRole2(1L));

        return userMapper.insert(user);
    }

    @Override
    public User getUserByLogin(String login) {
        log.info("method=getUserByLogin, login={}", login);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("login", login).andEqualTo("isDelete",false);
        return userMapper.selectOneByExample(example);
    }

}
