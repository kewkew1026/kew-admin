/*
 * Copyright (C) 2017 kew All Rights Reserved.
 * 
 *
 */
package com.kew.${c.groupId}.model.enums;
import java.io.Serializable;


import com.kew.service.ModelEnumService;
import com.kew.utils.EnumUtil;
/**
 *
 *
 * <br>
*/
public enum ${c.modelName}ModelKeyEnum implements Serializable,ModelEnumService {
		TEST("TEST","测试",null),
		;
		
		private final String code;
		private final String description;
		private final Enum parent;

		static{
			EnumUtil.ENUMS_TO_VIEW.put("${(c.modelName+'_Model_Key')?lower_case}", ${c.modelName}ModelKeyEnum.values());
		}


/**
		 * 私有构造函数
		 * @param code
		 * @param description
		 */
		${c.modelName}ModelKeyEnum(String code, String description,Enum parent) {
			this.code = code;
			this.description = description;
			this.parent = parent;
		}

		/**
		 * @return Returns the code.
		 */
		public String getCode() {
			return code;
		}

		/**
		 * @return Returns the description.
		 */
		public String getDescription() {
			return description;
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
		 * @param description
		 * @return
		 */
		public static ${c.modelName}ModelKeyEnum getByDescription(String description) {
			if(description==null||"".equals(description)){
				return null;
			}
			for (${c.modelName}ModelKeyEnum menum : values()) {
				if (menum.getDescription().equals(description)) {
					return menum;
				}
			}
			return null;
		}
		public static ${c.modelName}ModelKeyEnum getByNo(String code) {
			if (code == null) {
				return null;
			}
			for (${c.modelName}ModelKeyEnum menum : values()) {
				if (menum.getCode().equals(code)) {
					return menum;
				}
			}
			return null;
		}

		@Override
		public String modelPrex() {
			return this.getCode();
		}
}
