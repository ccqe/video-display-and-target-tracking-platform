package com.project.service.iface;


import java.util.List;

import com.project.entity.Camera;
import com.project.vo.CameraQueryVo;
import com.project.vo.RtmpQueryVo;



public interface CameraService {
	/*
	 * name:getRtmp
	 * input:null
	 * output:Map<String, Object>
	 * page:/control
	 * needValue:name
	 * 			 rtmpSrc
	 */
	public List<RtmpQueryVo> getRtmp();
	
	/*
	 * name:getRtmp
	 * input:null
	 * output:List<QueryCameraVo>
	 * page:/mapshow
	 * needValue:name
	 * 			 positionX
	 * 			 positionY
	 * 			 peopleNum
	 * 			 vehickesNum
	 */
	public List<CameraQueryVo> getCamera();
	
	/*
	 * name:getCameraId
	 * input:name
	 * output:id
	 * page:/video
	 * needValue:camera.id
	 */
	public int getCameraId(String name);
	
	public List<Camera> getCameralistBykey(String key);
	
	public void addCamera(Camera camera);
	
	public void deleteCamera(int id);
	
	public void updateCamera(Camera camera);
}
