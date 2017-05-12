package com.kew.${c.groupId}.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.kew.${c.groupId}.dto.BaseRequestDTO;
import com.kew.${c.groupId}.dto.BaseResponseDTO;
import com.kew.${c.groupId}.enums.ResultCodeEnum;
import com.kew.${c.groupId}.service.CommonAbstractHandler;
/**
* 实例
* @author kew
*
*/
@Service("testBuildHandler")
public class TestBuildHandler extends CommonAbstractHandler {
private static Logger log = Logger.getLogger(TestBuildHandler.class);

    /*
    @Autowired
    private A a;
    */

    @Override
    public BaseResponseDTO<Object> doBusiness(BaseRequestDTO reqDto) {
        BaseResponseDTO<Object> res = new BaseResponseDTO<Object>();
        res.setResult(ResultCodeEnum.FAIL.getCode());
        return res;
    }
}
