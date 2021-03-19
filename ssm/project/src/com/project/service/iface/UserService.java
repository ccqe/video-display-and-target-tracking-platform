package com.project.service.iface;

import java.util.List;


import com.project.entity.User;


public interface UserService {
	public Boolean login(User user);
	
	public List<User> getUserlistBykey(String key);
	
	public void addUser(User user);
	
	public void deleteUser(int id);
	
	public void updateUser(User user);

}
