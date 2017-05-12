/*
 * 消息类型
 * author:chenghong
 * 创建时间:2011-7-22
 */
package com.kew.boss.model;

import java.io.Serializable;

public class MessageType implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2502837533624043198L;
	private String messageTypeCode ;//消息类型编码
    private String messageTypeName ;//消息类型名称
    private String messageTypeValue ; //消息类型值
    
	public MessageType() {
		super();
	}
	
	public MessageType(String messageTypeCode, String messageTypeName,
			String messageTypeValue) {
		super();
		this.messageTypeCode = messageTypeCode;
		this.messageTypeName = messageTypeName;
		this.messageTypeValue = messageTypeValue;
	}

	public String getMessageTypeCode() {
		return messageTypeCode;
	}
	public void setMessageTypeCode(String messageTypeCode) {
		this.messageTypeCode = messageTypeCode;
	}
	public String getMessageTypeName() {
		return messageTypeName;
	}
	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}
	public String getMessageTypeValue() {
		return messageTypeValue;
	}
	public void setMessageTypeValue(String messageTypeValue) {
		this.messageTypeValue = messageTypeValue;
	}
    
    
}
