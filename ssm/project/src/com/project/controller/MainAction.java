package com.project.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.entity.Camera;
import com.project.entity.User;
import com.project.service.iface.CameraService;
import com.project.service.iface.PeopleService;
import com.project.service.iface.UserService;
import com.project.service.iface.VehiclesService;
import com.project.service.iface.VideoService;
import com.project.vo.CameraQueryVo;
import com.project.vo.RtmpQueryVo;



@Controller
@RequestMapping("api")
public class MainAction {
	@Resource
	private CameraService cameraSerive;
	@Resource
	private VideoService videoSerive;
	@Resource
	private PeopleService peopleSerive;
	@Resource
	private VehiclesService vehiclesSerive;
	@Resource
	private UserService userSerive;
	

	@RequestMapping(value = "rtmp",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getRtmp() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<RtmpQueryVo> c = cameraSerive.getRtmp();
		
		String key = "rtmpInfo";		
		map.put(key, c);
		return map;

	}
	
	@RequestMapping(value = "camera",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> getCamera() {
		Map<String,Object> map = new HashMap<String,Object>();
	    List<CameraQueryVo> c = cameraSerive.getCamera();
	    
	    String key = "camera";
	    map.put(key, c);
		return map;
		

	}
	
	@RequestMapping(value = "video",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getVideo(@RequestBody  Map<String,String> body) {
		String name = body.get("name");
		
		String date = body.get("date");	
		
		String tm = body.get("time").substring(11, 13);
		int t = Integer.valueOf(tm).intValue();
		if(t<16) {
			t= t+8;
		}
		else{
			t=t-16;
		}
		String time = String.valueOf(t); 
		
		Map<String,String> map = new HashMap<String,String>();
				
		String datetime = date+" "+time+":00:00";		
		int id = cameraSerive.getCameraId(name);
			    				
		String value = videoSerive.getVideo(id, datetime);
		
		String key = "src";		
		map.put(key, value);		
		return map;		

	}
	
	@RequestMapping(value = "data",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Integer[][]> getData(@RequestBody Map<String,String> body) {
		
		String name = body.get("name");
		
		Map<String, Integer[][]> map = new HashMap<String,Integer[][]>();
				
		int id = cameraSerive.getCameraId(name);
		List<Integer> p = peopleSerive.getPeopleNumber(id);
		List<Integer> v = vehiclesSerive.getVehiclesNumber(id);
		
		String key = "data";
		Integer[][] value = new Integer[2][24];
		for(int i=0;i<p.size();i++) {
			value[0][i] = p.get(i);
		}
		for(int i=0;i<v.size();i++) {
			value[1][i] = v.get(i);
		}
		map.put(key, value);
		return map;

	}
	
	@RequestMapping(value = "cameralist",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getCameralist(@RequestBody Map<String,Object> body) {
		System.out.println(body);
		
		String name = (String) body.get("name");
		System.out.println(name);
		
		Map<String,Object> map = new HashMap<String,Object>();
				
		List<Camera> list = cameraSerive.getCameralistBykey(name);
		
		
		String key = "list";
		String pageTotal ="pageTotal";
		
		map.put(key,list);
		map.put(pageTotal, list.size());
		
		return map;

	}
	
	@RequestMapping(value = "deletecamera",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deletecamera(@RequestBody Map<String,String> body) {
		System.out.println(body);
		
		int id = Integer.valueOf(body.get("id")).intValue();
		System.out.println(body.get("id"));
		
		Map<String,Object> map = new HashMap<String,Object>();
				
		cameraSerive.deleteCamera(id);
		
		
		String key = "state";
		
		map.put(key,true);
		
		
		return map;

	}
	
	@RequestMapping(value = "addcamera",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addcamera(@RequestBody Map<String,String> body) {
		System.out.println(body);
		
		int id = Integer.valueOf(body.get("id")).intValue();
		String name = body.get("name");
		double positionX = Double.valueOf(body.get("positionX")).doubleValue();
		double positionY = Double.valueOf(body.get("positionY")).doubleValue();
		String rtmpSrc = body.get("rtmpSrc");
		
		Camera awe=new Camera();
		awe.setId(id);
		awe.setName(name);
		awe.setPositionX(positionX);
		awe.setPositionY(positionY);
		awe.setRtmpSrc(rtmpSrc);
		
		Map<String,Object> map = new HashMap<String,Object>();
				
		cameraSerive.addCamera(awe);
		
		
		String key = "state";
		
		map.put(key,true);
		
		System.out.println(map);
		
		return map;

	}
	
	@RequestMapping(value = "updatecamera",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updatecamera(@RequestBody Map<String,String> body) {
		System.out.println(body);
		
		int id = Integer.valueOf(body.get("id")).intValue();
		String name = body.get("name");
		double positionX = Double.valueOf(body.get("positionX")).doubleValue();
		double positionY = Double.valueOf(body.get("positionY")).doubleValue();
		String rtmpSrc = body.get("rtmpSrc");
		
		Camera awe=new Camera();
		awe.setId(id);
		awe.setName(name);
		awe.setPositionX(positionX);
		awe.setPositionY(positionY);
		awe.setRtmpSrc(rtmpSrc);

		
		Map<String,Object> map = new HashMap<String,Object>();
				
		cameraSerive.updateCamera(awe);
		
		
		String key = "state";
		
		map.put(key,true);
		
		System.out.println(map);
		
		return map;

	}
	
	@RequestMapping(value = "login",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> login(@RequestBody Map<String,Object> body) {
		System.out.println(body);
		
		String username = (String) body.get("username");
		String password = (String) body.get("password");
		
		User awe=new User();
		awe.setUsername(username);
		awe.setPassword(password);

		
		Map<String,Object> map = new HashMap<String,Object>();
				
		Boolean result = userSerive.login(awe);
		
		
		String key = "state";
		
		map.put(key,result);
		
		return map;

	}
	
	@RequestMapping(value = "userlist",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getUserlist(@RequestBody Map<String,Object> body) {
		System.out.println(body);
		
		String name = (String) body.get("username");
		System.out.println(name);
		
		Map<String,Object> map = new HashMap<String,Object>();
				
		List<User> list = userSerive.getUserlistBykey(name);
		
		
		String key = "list";
		String pageTotal ="pageTotal";
		
		map.put(key,list);
		map.put(pageTotal, list.size());
		
		return map;

	}
	
	@RequestMapping(value = "deleteuser",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteuser(@RequestBody Map<String,String> body) {
		System.out.println(body);
		
		int id = Integer.valueOf(body.get("id")).intValue();
		System.out.println(body.get("id"));
		
		Map<String,Object> map = new HashMap<String,Object>();
				
		userSerive.deleteUser(id);
		
		
		String key = "state";
		
		map.put(key,true);
		
		
		return map;

	}
	
	@RequestMapping(value = "adduser",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> adduser(@RequestBody Map<String,String> body) {
		System.out.println(body);
		
		int id = Integer.valueOf(body.get("id")).intValue();
		String username = body.get("username");
		String password = body.get("password");

		Date date = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:00:00");	    
	    String datetime = ft.format(date);
		
		User awe=new User();
		awe.setId(id);
		awe.setUsername(username);
		awe.setPassword(password);
		awe.setDatetime(datetime);
		
		Map<String,Object> map = new HashMap<String,Object>();
				
		userSerive.addUser(awe);
		
		
		String key = "state";
		
		map.put(key,true);
		
		System.out.println(map);
		
		return map;

	}
	
	@RequestMapping(value = "updateuser",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateuser(@RequestBody Map<String,String> body) {
		System.out.println(body);
		
		int id = Integer.valueOf(body.get("id")).intValue();
		String username = body.get("username");
		String password = body.get("password");
		
		User awe=new User();
		awe.setId(id);
		awe.setUsername(username);
		awe.setPassword(password);
		
		Map<String,Object> map = new HashMap<String,Object>();
				
		userSerive.updateUser(awe);
		
		
		String key = "state";
		
		map.put(key,true);
		
		System.out.println(map);
		
		return map;

	}
	
}
