package com.project.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.entity.Camera;
import com.project.mapper.CameraMapper;
import com.project.service.iface.CameraService;
import com.project.vo.CameraQueryVo;
import com.project.vo.RtmpQueryVo;

@Service
public class CameraServiceImpl implements CameraService{
	@Resource
	private CameraMapper cameraMapper;
	
	public List<RtmpQueryVo> getRtmp(){
		
		return cameraMapper.findAllCamera();
		
	}
	
	public List<CameraQueryVo> getCamera(){
		Date date = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:00:00");
	    
	    return cameraMapper.findCameraByDate(ft.format(date));
	    
		
	}
	
	public int getCameraId(String name){
			
		return cameraMapper.findCameraIdByName(name);
			
	}
	
	public List<Camera> getCameralistBykey(String key){
		key = "%"+key+"%";
		
		return cameraMapper.findCameraBykey(key);
			
	}
	
	public void addCamera(Camera camera) {
		cameraMapper.addCamera(camera);
	}
	
	public void deleteCamera(int id) {
		cameraMapper.deleteCamera(id);
	}
	
	public void updateCamera(Camera camera) {
		cameraMapper.updateCamera(camera);
	}

}
