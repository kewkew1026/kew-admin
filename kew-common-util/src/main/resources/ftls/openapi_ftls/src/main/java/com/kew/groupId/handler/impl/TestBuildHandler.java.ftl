package com.kew.${c.groupId}.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.kew.${c.groupId}.dto.BaseRequestDTO;
import com.kew.${c.groupId}.dto.BaseResponseDTO;
import com.kew.${c.groupId}.enums.ResultCodeEnum;
import com.kew.${c.groupId}.service.CommonAbstractHandler;
/**
* 添加会员收藏接口
* @author Administrator
*
*/
@Service("testBuildHandler")
public class TestBuildHandler extends CommonAbstractHandler {
private static Logger log = Logger.getLogger(TestBuildHandler.class);

/*
@Autowired
private MessageScheduingService messageScheduingService;
*/

@Override
public BaseResponseDTO<Object> doBusiness(BaseRequestDTO reqDto) {
    BaseResponseDTO<Object> res = new BaseResponseDTO<Object>();
        res.setResult(ResultCodeEnum.FAIL.getCode());
        /*
        MessageScheduingDto messageScheduingDto = new MessageScheduingDto();

        messageScheduingDto.setScheduingNo("Test_"+System.currentTimeMillis());
        messageScheduingDto.setMsgType(MsgTypeEnum.EMAIL.getNo());
        messageScheduingDto.setReciverSignName("taojun@elineprint.com");
        messageScheduingDto.setSendStatus(SendStatusEnum.DEFAULT.getNo());

        messageScheduingService.create(messageScheduingDto);

        res.setContent(messageScheduingService.getPageModel(new MessageScheduingDto(),0, 100));
        */
        res.setResult(ResultCodeEnum.SUCCESS.getCode());
        return res;
        }
        }
