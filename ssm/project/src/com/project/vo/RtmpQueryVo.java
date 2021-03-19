package com.project.vo;

public class RtmpQueryVo {
	private String name;
	private String rtmpSrc;
	@Override
	public String toString() {
		return "RtmpQueryVo [name=" + name + ", rtmpSrc=" + rtmpSrc + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRtmpSrc() {
		return rtmpSrc;
	}
	public void setRtmpSrc(String rtmpSrc) {
		this.rtmpSrc = rtmpSrc;
	}

}
