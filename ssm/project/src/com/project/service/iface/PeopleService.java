package com.project.service.iface;

import java.util.List;

public interface PeopleService {
	/*
	 * name:getPeopleNumber
	 * input:id 
	 * output:List<Integer>
	 * page:/statistics
	 * needValue:people.number
	 * 按摄像头id，对人数进行提取
	 */
	public List<Integer> getPeopleNumber(int id);
}
