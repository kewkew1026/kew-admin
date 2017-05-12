package com.kew.boss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qiudanping on 2017/5/9.
 */
@Controller
@RequestMapping({"/"})
public class LoginController extends BaseController
{
    @RequestMapping({"/"})
    public String login(Model model) {
        model.addAttribute("message","");
        // 登陆页面
        return "login";
    }
}

