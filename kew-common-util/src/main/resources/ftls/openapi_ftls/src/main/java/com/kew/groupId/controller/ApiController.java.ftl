package com.kew.${c.groupId}.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kew.${c.groupId}.dto.BaseResponseDTO;
import com.kew.${c.groupId}.dto.BaseRequestDTO;

import com.kew.${c.groupId}.handler.impl.TestBuildHandler;


@Controller
@RequestMapping("/api")
public class ApiController extends BaseController{

@Autowired
TestBuildHandler testBuildHandler;


@RequestMapping("/testbuild")
public @ResponseBody BaseResponseDTO login(Model model, HttpServletRequest request, BaseRequestDTO reqDto) {
return testBuildHandler.Handler(reqDto);
}


}
