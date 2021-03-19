package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.User;

public interface UserMapper {
	public User loginUser(@Param("user")User user);
	
	public List<User> findUserBykey(@Param("key")String key);
	
	public void addUser(@Param("user")User user);
	
	public void deleteUser(@Param("id")int id);
	
	public void updateUser(@Param("user")User user);

}
