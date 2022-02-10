package com.imooc.controller;

import com.imooc.controller.frontend.MainPageController;
import com.imooc.controller.superadmin.HeadLineOperationController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("request path is" + req.getServletPath());
        System.out.println("request method is" + req.getMethod());
        if (req.getServletPath() == "/frontend/getmainpageinfo" && req.getMethod() == "GET"){
            new MainPageController().getMainPageInfo(req,resp);
        }else if (req.getServletPath() == "/superadmin/addheadline" && req.getMethod() == "POST"){
            new HeadLineOperationController().addHeadLine(req,resp);
        }


    }

}
