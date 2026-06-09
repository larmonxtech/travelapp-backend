package com.xplorelatam.service;

import com.xplorelatam.model.User;

public interface IUserService extends IGenericService<User, Integer> {
    User findOneByUsername(String username);
    void changePassword(String username, String password);
}
