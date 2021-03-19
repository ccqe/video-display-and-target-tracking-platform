package com.project.entity;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private String password;
	private String datetime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "User [userid=" + id + ", username=" + username + ", password=" + password + ", datetime=" + datetime
				+ "]";
	}
	

}
