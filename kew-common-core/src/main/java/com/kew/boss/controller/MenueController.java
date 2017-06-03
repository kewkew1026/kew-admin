/*
 * Copyright (C) 2011 kew All Rights Reserved.
 * 
 * MenueController.java
 */
package com.kew.boss.controller;


import com.alibaba.fastjson.JSONObject;
import com.kew.boss.directives.BaseResponseDto;
import com.kew.boss.enums.ResultCodeEnum;
import com.kew.boss.model.FunOpt;
import com.kew.boss.model.Menue;
import com.kew.boss.model.User;
import com.kew.boss.service.FunOptService;
import com.kew.boss.service.MenueService;
import com.kew.boss.utils.MenuUtil;
import com.kew.constants.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menue")
public class MenueController extends BaseController {
    /**
     * 菜单service
     */
    @Autowired
    private MenueService menueService = null;

    /**
     * 资源service
     */
    @Autowired
    private FunOptService funOptService = null;

    /**
     * 菜单树展现Controller
     *
     * @param model          model
     * @param leftRefreshFlg true：左菜单刷新 false:不刷新
     * @return 画面迁移
     */
    @RequestMapping("/list")
    public String list(Model model, String leftRefreshFlg, HttpServletRequest request) {

        return "/right/menue";
    }

    /**
     * 得到菜单
     *
     * @param model
     * @param leftRefreshFlg
     * @param request
     * @return
     */
    @RequestMapping("/getMenue")
    public
    @ResponseBody
    BaseResponseDto
    getMenue(Model model, String leftRefreshFlg, HttpServletRequest request) throws Exception {
        BaseResponseDto baseResponseDto = new BaseResponseDto();
        baseResponseDto.setContent(menueService.getMenueList(false, MenuUtil.getRoleIds(request), MenuUtil.getUsername(request)));
        return baseResponseDto;
    }

    /**
     * 得到功能IDS
     *
     * @param model
     * @param leftRefreshFlg
     * @param request
     * @return
     */
    @RequestMapping("/getFunIds")
    public
    @ResponseBody
    BaseResponseDto getFunIds(Model model, String leftRefreshFlg, HttpServletRequest request, HttpServletResponse response) throws Exception {
        BaseResponseDto baseResponseDto = new BaseResponseDto();
        List<FunOpt> funOpts = funOptService.data();
        baseResponseDto.setContent(createMyFunIds(funOpts));
        return baseResponseDto;
    }

    /**
     * 菜单创建保存按钮Controller
     *
     * @param model   model
     * @param menue   菜单
     * @param session session
     * @return 画面迁移
     */
    @RequestMapping("/saveMenue")
    public
    @ResponseBody
    BaseResponseDto saveMenue(Model model, Menue menue, HttpSession session, HttpServletResponse response) throws Exception {
        BaseResponseDto baseResponseDto = new BaseResponseDto();
        // 获取当前用户信息
        User user = (User) session.getAttribute(SysConstants.SESSION_USERINFO);
        menue.setStaffId(user.getUserId());

        if (menue != null) {
            if (menue.getParMenueId() == 0) {
                menue.setParMenueId(SysConstants.MENU_DEFAULT_ID);
            }
            if (menue.getFunOptId() == SysConstants.MENU_COMBOX_ID) {
                menue.setFunOptId(0);
            }
        }

        //验证当前menue的序号是否合法
        boolean isValideNumber = menueService.isValideNumber(menue);
        if (!isValideNumber) {
            baseResponseDto.setErrorCode(ResultCodeEnum.MENUE_CODE_EXIST);
        } else {
            menueService.insertMenue(menue);
        }
        return baseResponseDto;

    }

    /**
     * 菜单变更画面初始化Controller
     *
     * @param model   model
     * @param menueId 菜单id
     * @return 画面迁移
     */
    @RequestMapping("/updtMenueInit")
    public
    @ResponseBody
    Menue updtMenueInit(Model model, long menueId, HttpServletResponse response) throws Exception {
        // 设置要变更的菜单信息
        Menue menue = menueService.srchMenue(menueId);
        if (menue != null) {
            if (menue.getFunOptId() == 0) {
                menue.setFunOptId(SysConstants.MENU_COMBOX_ID);
            }
        }

        return menue;

    }

    /**
     * 菜单创变更保存按钮Controller
     *
     * @param model   model
     * @param menue   菜单
     * @param session session
     * @return 画面迁移
     */
    @RequestMapping("/updtMenue")
    public String updtMenue(Model model, Menue menue, HttpSession session, HttpServletResponse response) throws Exception {
        // 获取当前用户信息
        User user = (User) session.getAttribute(SysConstants.SESSION_USERINFO);
        if (menue != null) {
            if (menue.getFunOptId() == SysConstants.MENU_COMBOX_ID) {
                menue.setFunOptId(0);
            }
            menue.setStaffId(user.getUserId());
        }

        //验证当前menue的序号是否合法
        boolean isValideNumber = menueService.isValideNumberEdit(menue);
        if (!isValideNumber) {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("{\"msg\":\"菜单号不能重复!\"}");
            return null;
        }

        // 变更菜单信息
        menueService.updateMenue(menue);
        response.getWriter().write("{\"success\":true}");
        return null;
    }

    /**
     * 菜单删除按钮Controller
     *
     * @param model   model
     * @param menueId 菜单id
     * @return 画面迁移
     */
    @RequestMapping("/delMenue")
    public String delMenue(Model model, long menueId, HttpServletResponse response) {

        try {
            menueService.delMenue(menueId);
            response.setContentType("application/json");
            response.getWriter().write("{\"success\":true}");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().write("{\"msg\":\"删除失败!\"}");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;

    }

    //提供数据以便制作成json
    private List<Menue> createMenueListMap(List<Menue> childrenMenueList) {
        if (childrenMenueList != null && childrenMenueList.size() > 0) {
            for (Menue menue : childrenMenueList) {
                String menueUrl = menue.getMenueUrl();
                menueUrl = (menueUrl == null) ? "" : menueUrl;
                long menueId = menue.getMenueId();
                String menueNm = menue.getMenueNm();

                menue.setText(menueNm);
                menue.setId(menueId + "");
                menue.setUrl(menueUrl);
                menue.setChildren(menue.getChildrenMenueList());
                //menue.setState("closed");

                if (menue.getChildrenMenueList() != null && menue.getChildrenMenueList().size() > 0) {
                    createMenueListMap(menue.getChildrenMenueList());
                }
            }
        }
        return childrenMenueList;
    }

    //提供数据以便制作成json
    private List<Map> createMyFunIds(List<FunOpt> funOpts) {

        List<Map> list = new ArrayList<Map>();
        //初始化一个数据
        Map _map = new HashMap();
        _map.put("id", SysConstants.MENU_COMBOX_ID);
        _map.put("text", SysConstants.MENU_COMBOX_TEXT);
        _map.put("selected", true);
        list.add(_map);
        for (int i = 0; i < funOpts.size(); i++) {
            FunOpt myGroup = funOpts.get(i);
            Map map = new HashMap();
            map.put("id", myGroup.getFunOptId());
            map.put("text", myGroup.getFunOptNm());
            list.add(map);
        }

        return list;
    }
}
