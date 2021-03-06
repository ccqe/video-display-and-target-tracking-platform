package com.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.entity.Camera;
import com.project.vo.CameraQueryVo;
import com.project.vo.RtmpQueryVo;

public interface CameraMapper {		
		
		public List<RtmpQueryVo> findAllCamera();
		public List<CameraQueryVo> findCameraByDate(String datetime);
		public int findCameraIdByName(String name);
		
		public List<Camera> findCameraBykey(@Param("key")String key);
		public void addCamera(Camera camera);
		
		public void deleteCamera(@Param("id")int id);
		
		public void updateCamera(@Param("camera")Camera camera);

		
}
