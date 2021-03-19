package com.project.entity;

import java.util.Date;

public class Video {
	private Date datetime;
	private int cameraId;
	private String videoSrc;
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getVideoSrc() {
		return videoSrc;
	}
	public void setVideoSrc(String videoSrc) {
		this.videoSrc = videoSrc;
	}
	public int getCameraId() {
		return cameraId;
	}
	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}
	@Override
	public String toString() {
		return "Video [datetime=" + datetime + ", cameraId=" + cameraId + ", videoSrc=" + videoSrc + "]";
	}
	
	
}
