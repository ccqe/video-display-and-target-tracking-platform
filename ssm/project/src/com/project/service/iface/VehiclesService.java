package com.project.service.iface;

import java.util.List;

public interface VehiclesService {
	/*
	 * name:getVehiclesNumber
	 * input:id 
	 * output:List<Integer>
	 * page:/statistics
	 * needValue:vehicles.number
	 * ������ͷid���Գ�����������ȡ
	 */
	public List<Integer> getVehiclesNumber(int id);
	
}
