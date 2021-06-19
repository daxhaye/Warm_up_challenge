package com.challengewarmup.models.dao;

import com.challengewarmup.models.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long> {
	
	public User findByEmail(String Email);
}
