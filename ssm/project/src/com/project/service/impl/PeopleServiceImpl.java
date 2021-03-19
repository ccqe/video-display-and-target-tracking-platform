package com.project.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.mapper.PeopleMapper;
import com.project.service.iface.PeopleService;

@Service
public class PeopleServiceImpl implements PeopleService{
	@Resource
	private PeopleMapper peopleMapper;
	
	public List<Integer> getPeopleNumber(int id){

		return peopleMapper.findAllPeopleNumber(id);
		
	}
	
	
	
}
