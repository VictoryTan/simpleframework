package com.imooc;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/8
 * @Version: 1.0
 */
@WebServlet(value = "/hello")
@Slf4j
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("你好。。。。");
        String name = "my simple framework";
        req.setAttribute("name",name);
        System.out.println("hello");
        req.getRequestDispatcher("WEB-INF/jsp/hello.jsp").forward(req,resp);
    }
}
