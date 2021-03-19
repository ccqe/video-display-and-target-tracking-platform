package com.project.vo;

public class CameraQueryVo {
	private String name;
	private double positionX;
	private double positionY;
	
	private int peopleNum;
	private int vehiclesNum;
	
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
	public double getPositonY() {
		return positionY;
	}
	public void setPositonY(double positonY) {
		this.positionY = positonY;
	}
	
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	public int getVehiclesNum() {
		return vehiclesNum;
	}
	public void setVehiclesNum(int vehiclesNum) {
		this.vehiclesNum = vehiclesNum;
	}
	public double getPositionY() {
		return positionY;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	@Override
	public String toString() {
		return "QueryCameraVo [name=" + name + ", positionX=" + positionX + ", positionY=" + positionY + ", peopleNum="
				+ peopleNum + ", vehiclesNum=" + vehiclesNum + "]";
	}
	
	
	
}
