package com.project.entity;

public class Camera {
	private int id;
	private String name;
	private double positionX;
	private double positionY;
	private String rtmpSrc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPositionX() {
		return positionX;
	}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public double getPositionY() {
		return positionY;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	public String getRtmpSrc() {
		return rtmpSrc;
	}
	public void setRtmpSrc(String rtmpSrc) {
		this.rtmpSrc = rtmpSrc;
	}
	@Override
	public String toString() {
		return "Camera [id=" + id + ", name=" + name + ", positionX=" + positionX + ", positionY=" + positionY
				+ ", rtmpSrc=" + rtmpSrc + "]";
	}
	
	
	
}
