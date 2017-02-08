/*
 * Copyright (C) 2017 kew All Rights Reserved.
 * 
 *
 */
package com.kew.${c.groupId}.model.enums;
import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.kew.service.ModelEnumService;
/**
 *
 *
 * <br>
*/
public enum ${c.modelName}ModelKeyEnum implements Serializable,ModelEnumService {
		TEST("TEST","测试",null),
		;
		
		private final String no;
		private final String des;
		private final Enum parent;
		
		/**
		 * 私有构造函数
		 * @param code
		 * @param description
		 */
		${c.modelName}ModelKeyEnum(String no, String des,Enum parent) {
			this.no = no;
			this.des = des;
			this.parent = parent;
		}

		/**
		 * @return Returns the no.
		 */
		public String getNo() {
			return no;
		}

		/**
		 * @return Returns the des.
		 */
		public String getDes() {
			return des;
		}
		
		/**
		 * @return Returns the parent.
		 */
		public Enum getParent() {
			return parent;
		}

		/**
		 * 通过枚举<code>des</code>获得枚举
		 * 
		 * @param des
		 * @return
		 */
		public static ${c.modelName}ModelKeyEnum getByDescription(String des) {
			if(StringUtils.isBlank(des)){
				return null;
			}
			for (${c.modelName}ModelKeyEnum menum : values()) {
				if (menum.getDes().equals(des)) {
					return menum;
				}
			}
			return null;
		}
		public static ${c.modelName}ModelKeyEnum getByNo(String no) {
			if(StringUtils.isBlank(no)){
				return null;
			}
			for (${c.modelName}ModelKeyEnum menum : values()) {
				if (menum.getNo().equals(no)) {
					return menum;
				}
			}
			return null;
		}

		@Override
		public String modelPrex() {
			return this.getNo();
		}
}
