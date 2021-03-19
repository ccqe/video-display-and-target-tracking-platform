package com.project.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.mapper.VehiclesMapper;
import com.project.service.iface.VehiclesService;

@Service
public class VehiclesServiceImpl implements VehiclesService{
	@Resource
	private VehiclesMapper vehiclesMapper;
	
	public List<Integer> getVehiclesNumber(int id){

		return vehiclesMapper.findAllVehiclesNumber(id);
		
	}

}
