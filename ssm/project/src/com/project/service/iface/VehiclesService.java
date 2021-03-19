package com.project.service.iface;

import java.util.List;

public interface VehiclesService {
	/*
	 * name:getVehiclesNumber
	 * input:id 
	 * output:List<Integer>
	 * page:/statistics
	 * needValue:vehicles.number
	 * 按摄像头id，对车辆数进行提取
	 */
	public List<Integer> getVehiclesNumber(int id);
	
}
