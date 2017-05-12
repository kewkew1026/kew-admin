/*
 * 消息
 * author:chenghong
 * 创建时间：2011-7-21
 */
package com.kew.boss.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private long id;                     //消息id
	private long sendUserId ;            //发送人用户ID
	private long receUserId ;            //接收用户ID
	private String status ;              //消息状态
	private String title ;               //消息标题
	private String content ;             //消息内容
	private String sendUserType ;        //发送用户类型
	private String receUsertype;         //接收用户类型
	private String messageTypeCode ;     //消息类型编码
	private Date sendDate ;              //消息发送日期
	
	public Message(){
		super();
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Message(long id, String title, String content, long sendUserId,
			String sendUserType, long receUserId, String receUsertype,
			Date sendDate, String status, String messageTypeCode) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.sendUserId = sendUserId;
		this.sendUserType = sendUserType;
		this.receUserId = receUserId;
		this.receUsertype = receUsertype;
		this.sendDate = sendDate;
		this.status = status;
		this.messageTypeCode = messageTypeCode;
	}

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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getSendUserId() {
		return sendUserId;
	}
	public void setSendUserId(long sendUserId) {
		this.sendUserId = sendUserId;
	}
	public String getSendUserType() {
		return sendUserType;
	}
	public void setSendUserType(String sendUserType) {
		this.sendUserType = sendUserType;
	}
	public long getReceUserId() {
		return receUserId;
	}
	public void setReceUserId(long receUserId) {
		this.receUserId = receUserId;
	}
	public String getReceUsertype() {
		return receUsertype;
	}
	public void setReceUsertype(String receUsertype) {
		this.receUsertype = receUsertype;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessageTypeCode() {
		return messageTypeCode;
	}
	public void setMessageTypeCode(String messageTypeCode) {
		this.messageTypeCode = messageTypeCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
