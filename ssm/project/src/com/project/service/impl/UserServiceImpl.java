package com.project.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.mapper.UserMapper;
import com.project.service.iface.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> getUserlistBykey(String key) {
		key = "%"+key+"%";
		
		return userMapper.findUserBykey(key);
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
		
	}

	@Override
	public void deleteUser(int id) {
		userMapper.deleteUser(id);
		
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
		
	}

	@Override
	public Boolean login(User user) {
		if(userMapper.loginUser(user) != null) {
			return true;
		}
		else {
			return false;
		}
	}

}
