package com.userdata.user.UserDao;

import java.util.List;

import com.userdata.user.model.MobileUpdate;
import com.userdata.user.model.Response;
import com.userdata.user.model.User;

public interface UserDao {
	
	public int count();

	public List<User> findAll();

	public List<User> findAllById(Integer id);
	
	public User addPersons(User user) throws Exception;

	public User updateUserMobile(User user);

	int getUserUpdate(User user, int id);

	int deleteById(int id);

	int deleteByIdTrue(User user, int id);
	
	

}
