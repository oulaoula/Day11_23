package com.oracleoaec.entity;

import java.io.Serializable;
import java.sql.Date;

public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long hnId;//新闻id，序列产生
	private String hnTitle;//标题
	private String hnContent;//主体部分
	private Date hnCreateTime;//创建时间
	
	public News() {
		
	}

	
	
	public News(Long hnId, String hnTitle, String hnContent, Date hnCreateTime) {
		this.hnId = hnId;
		this.hnTitle = hnTitle;
		this.hnContent = hnContent;
		this.hnCreateTime = hnCreateTime;
	}



	public Long getHnId() {
		return hnId;
	}

	public void setHnId(Long hnId) {
		this.hnId = hnId;
	}

	public String getHnTitle() {
		return hnTitle;
	}

	public void setHnTitle(String hnTitle) {
		this.hnTitle = hnTitle;
	}

	public String getHnContent() {
		return hnContent;
	}

	public void setHnContent(String hnContent) {
		this.hnContent = hnContent;
	}

	public Date getHnCreateTime() {
		return hnCreateTime;
	}

	public void setHnCreateTime(Date hnCreateTime) {
		this.hnCreateTime = hnCreateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "News [hnId=" + hnId + ", hnTitle=" + hnTitle + ", hnContent=" + hnContent + ", hnCreateTime="
				+ hnCreateTime + "]";
	}

	
	
	
	
}
