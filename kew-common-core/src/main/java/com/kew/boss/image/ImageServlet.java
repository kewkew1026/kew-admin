package com.kew.boss.image;

import com.kew.utils.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.OutputStream;

/**
 * Created by qiudanping on 2017/5/9.
 */
public class ImageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(ImageServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            request.getSession().setAttribute("number", ImageUtil.wiriteImage(os,new Color(247,247,247),Color.blue));
        } catch (Exception ex) {
            logger.error("生成验证码图片异常", ex);
        }
    }

}
