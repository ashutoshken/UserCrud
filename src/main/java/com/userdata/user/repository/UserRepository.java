package com.userdata.user.repository;

import java.util.List;

import com.userdata.user.model.User;

public interface UserRepository {
	int save(User temp);

	int update(User temp);

	List<User> findAll();

}
