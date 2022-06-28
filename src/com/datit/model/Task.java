package com.datit.model;

import java.sql.Date;

public class Task {
	private long id;
	private String title;
	private Date target_time;
	private String description;
	private boolean status;
	private String user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTarget_time() {
		return target_time;
	}

	public void setTarget_time(Date target_time) {
		this.target_time = target_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
