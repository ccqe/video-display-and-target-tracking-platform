package com.project.mapper;

import org.apache.ibatis.annotations.Param;


public interface VideoMapper {
	
		public String findVideoByDatetimeAndId(@Param("id")int id,@Param("value")String datetime);
}
