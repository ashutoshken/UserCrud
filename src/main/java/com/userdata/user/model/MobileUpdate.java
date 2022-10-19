package com.userdata.user.model;

import lombok.experimental.PackagePrivate;

public class MobileUpdate {
	
	private Integer id;
	private String mobile;
	
	public MobileUpdate() {
		
	}
	
	public MobileUpdate(Integer id, String mobile) {
		super();
		this.id = id;
		this.mobile = mobile;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
	  return "MobileUpdate [id=" + id + ", mobile=" + mobile + "]";
	}
	
}
