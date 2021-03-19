package com.project.service.iface;


public interface VideoService {
	/*
	 * name:getVideo
	 * input:id 
	 * 		 datetime
	 * output:videoSrc
	 * page:/video
	 * needValue:video.videoSrc
	 */
	public String getVideo(int id,String datetime);
}
