package com.project.test;


import java.util.List;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.entity.Camera;
import com.project.entity.User;
import com.project.entity.Video;
import com.project.mapper.CameraMapper;
import com.project.mapper.PeopleMapper;
import com.project.mapper.VideoMapper;
import com.project.service.iface.CameraService;
import com.project.service.iface.PeopleService;
import com.project.service.iface.UserService;
import com.project.service.iface.VehiclesService;
import com.project.service.iface.VideoService;
import com.project.vo.CameraQueryVo;
import com.project.vo.RtmpQueryVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testTTT {
	@Autowired
	private CameraMapper cameraMapper;
	@Autowired
	private VideoMapper videoMapper;
	@Autowired
	private PeopleMapper peopleMapper;

	
	@Test
	public void testMapper()
	{
		/*List<Integer> d = peopleMapper.findAllPeopleNumber();
		
		System.out.println("---------------------");
		for (Integer integer : d) {
			System.out.println(integer);
		}*/
		
		/*System.out.println(cameraMapper.findCameraIdByName("camera1"));*/
		
		/*String v = videoMapper.findVideoByDatetimeAndId(1,"2020-4-26 01:00:00");
		System.out.println(v);*/
		//Could not autowire field: private com.project.service.iface.VideoService com.project.test.testJdbc.videoService;
	}
	
	
	

	
	@Autowired
	private CameraService cameraService;
	@Autowired
	private VideoService videoService;
	@Autowired
	private PeopleService peopleService;
	@Autowired
	private VehiclesService vehiclesService;
	@Autowired
	private UserService userService;
	
	@Test
	public void testService()
	{
		/*List<QueryCameraVo> row = cameraService.getCamera();
		System.out.println(row);*/
		
//		List<User> cc = userService.getUserlistBykey("a");
//		
//		System.out.println(cc);
		User awe=new User();
		awe.setUsername("admin");
		awe.setPassword("123123");
		System.out.println(awe);
		Boolean x= userService.login(awe);
		System.out.println(x);
		
//		userService.deleteUser(3);
		
		/*int id = cameraService.getCameraId("camera3");
		String datetime = "2020-4-26 01:00:00";
		Video v = videoService.getVideo(id, datetime);
		System.out.println(v);*/
		/*List<Integer> d = peopleService.getPeopleNumer(1);		
		System.out.println(d);*/
		
		/*List<Integer> d = vehiclesService.getVehiclesNumber(1);		
		System.out.println(d);*/
	}
	
}
