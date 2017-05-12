package com.kew.${c.groupId}.dto;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BaseRequestDTO {
    public BaseResponseDTO getResDto(){
        return new BaseResponseDTO();
    }

    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
