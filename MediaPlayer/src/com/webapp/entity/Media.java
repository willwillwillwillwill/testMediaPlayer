package com.webapp.entity;

public class Media {

	private int id;//��������Ƶid
	private String title;//��Ƶ����
	private String src;//��Ƶ��ŵ�ַ
	private String picture;//��Ƶ��ͼ
	private String descript;//��Ƶ����
	private String uptime;//�ϴ�ʱ��
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
}
