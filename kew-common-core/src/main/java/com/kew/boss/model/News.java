/*
 * 新闻
 * author:chenghong
 * 创建时间：2011-7-21
 */
package com.kew.boss.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable{
    private static final long serialVersionUID = 1L;
    private long newsId ;            //新闻ID
    private String zoneCode ;        //区域编码
    private String title ;           //新闻标题
    private String content ;         //新闻内容
    private Date publishTime ;       //发布时间
    private long publisher ;         //发布人用户Id
    private String status;           //状态
    private long auditUserId ;       //审核人用户Id
    private Date auditTime ;         //审核时间
    private Date startTime ;         //有效开始时间
    private Date endTime ;           //有效截止时间
    
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	public News() {
		super();
	}


	public News(long newsId, String zoneCode, String title, String content,
			Date publishTime, long publisher, String status,
			long auditUserId, Date auditTime, Date startTime, Date endTime) {
		super();
		this.newsId = newsId;
		this.zoneCode = zoneCode;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
		this.publisher = publisher;
		this.status = status;
		this.auditUserId = auditUserId;
		this.auditTime = auditTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public long getNewsId() {
		return newsId;
	}
	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}
	public String getZoneCode() {
		return zoneCode;
	}
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public long getPublisher() {
		return publisher;
	}
	public void setPublisher(long publisher) {
		this.publisher = publisher;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAuditUserId() {
		return auditUserId;
	}
	public void setAuditUserId(long auditUserId) {
		this.auditUserId = auditUserId;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
