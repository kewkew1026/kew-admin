package com.kew.boss.controller;

import com.kew.boss.model.Menue;
import com.kew.boss.utils.MenuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by qiudanping on 2017/5/11.
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController
{


    @RequestMapping("/left")
    public String left(Model model, HttpServletRequest request) {
        // 获取所有的菜单
        Menue menue = menueService.getRootMenue(true, MenuUtil.getRoleIds(request), MenuUtil.getUsername(request));
        if(menue==null){
            model.addAttribute("menues",new ArrayList<Menue>());
        }else{
            model.addAttribute("menues", menue.getChildrenMenueList());
        }
        return "left";
    }

    @RequestMapping("/top")
    public String top(Model model,HttpServletRequest request) {
        // 获取所有的菜单
        model.addAttribute("username", MenuUtil.getUsername(request));
        return "top";
    }

    @RequestMapping("/main")
    public String main(Model model) {
        // 获取所有的菜单
        return "main";
    }

    @RequestMapping("/bottom")
    public String bottom(Model model) {
        // 获取所有的菜单
        return "bottom";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        // 获取所有的菜单
        return "login";
    }

}
