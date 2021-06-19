package com.challengewarmup.models.services;

import com.challengewarmup.models.entity.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

    public void save(User user);
}
