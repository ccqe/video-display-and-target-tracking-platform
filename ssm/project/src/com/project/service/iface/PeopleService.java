package com.project.service.iface;

import java.util.List;

public interface PeopleService {
	/*
	 * name:getPeopleNumber
	 * input:id 
	 * output:List<Integer>
	 * page:/statistics
	 * needValue:people.number
	 * ������ͷid��������������ȡ
	 */
	public List<Integer> getPeopleNumber(int id);
}
