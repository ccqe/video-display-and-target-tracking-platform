package com.project.entity;

import java.util.Date;

public class Vehicles {
	private Date datetime;
	private int cameraId;
	private int number;
	
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCameraId() {
		return cameraId;
	}
	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}
	@Override
	public String toString() {
		return "Vehicles [datetime=" + datetime + ", cameraId=" + cameraId + ", number=" + number + "]";
	}
	
	
	
}
