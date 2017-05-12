package com.kew.${c.groupId}.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kew.${c.groupId}.dto.BaseRequestDTO;
import com.kew.${c.groupId}.dto.BaseResponseDTO;
import com.kew.exception.OvalUNCheckedException;
import com.kew.exception.UNCheckedException;
import com.kew.utils.OvalUtil;

public abstract class CommonAbstractHandler {
        private static Log logger = LogFactory.getLog(CommonAbstractHandler.class);

        public BaseResponseDTO Handler(BaseRequestDTO reqDto){
            logger.info("业务请求["+this.getClass().getName()+"]请求参数:"+reqDto);
            BaseResponseDTO resDto = null;
            try{
                //验签
                //参数有效性验证
                OvalUtil.validate(reqDto);
                //业务处理/
                resDto = doBusiness(reqDto);
                }catch(OvalUNCheckedException e){
                    resDto = BaseResponseDTO.getDefaultResDto();
                    resDto.setErrorMsg(e.getMessage());
                    resDto.setErrorCode(e.getCode());
                    logger.warn(e.getMessage(),e);
                }catch(UNCheckedException e){
                    resDto = BaseResponseDTO.getDefaultResDto();
                    resDto.setErrorMsg(e.getOutMsg());
                    resDto.setErrorCode(e.getCode());
                    logger.warn(e.getOutMsg(),e);
                }catch(Exception e){
                    e.printStackTrace();
                    logger.error(e);
                    resDto = BaseResponseDTO.getDefaultResDto();
                    logger.error("运行时异常！",e);
                }finally{
                    //记录日志
                    logger.info("API业务处理结束:=>"+resDto);
                }
            //返回结果
            logger.info("请求结果:"+resDto);
            return resDto;
          }

        public abstract BaseResponseDTO doBusiness(BaseRequestDTO reqDto);

}
