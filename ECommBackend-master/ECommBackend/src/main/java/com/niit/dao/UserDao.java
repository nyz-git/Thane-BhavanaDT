package com.niit.dao;

import java.util.List;
import com.niit.model.User;

public interface UserDao {
	
	boolean insertUser(User user);
	public List<User> retrieveUser();
	public boolean deleteUser(User user);
	public User getUser(int catId);
	public boolean updateUser(User user);

}



