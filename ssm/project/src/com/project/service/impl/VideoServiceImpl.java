package com.project.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.project.mapper.VideoMapper;
import com.project.service.iface.VideoService;

@Service
public class VideoServiceImpl implements VideoService{
	@Resource
	private VideoMapper videoMapper;
	
	public String getVideo(int id,String datetime){
	
		return videoMapper.findVideoByDatetimeAndId(id, datetime);

		
	}
}
