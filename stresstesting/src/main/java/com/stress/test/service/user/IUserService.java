package com.stress.test.service.user;

import com.stress.test.domain.user.User;

public interface IUserService {

    int insertUser(User user);

    public User getUserByLogin(String login);
}
