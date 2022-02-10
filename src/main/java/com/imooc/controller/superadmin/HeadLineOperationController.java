package com.imooc.controller.superadmin;

import com.imooc.entity.bo.HeadLine;
import com.imooc.entity.dto.Result;
import com.imooc.service.solo.HeadLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:
 * @author: air
 * @create: 2020-03-14 11:25
 */
public class HeadLineOperationController {

    private HeadLineService headLineService;

    public Result<Boolean> addHeadLine(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("HeadLineOperationController.addHeadLine");

        return headLineService.addHeadLine(new HeadLine());
    }

    public Result<Boolean> removeHeadLine(HttpServletRequest request, HttpServletResponse response) {
        return headLineService.removeHeadLine(new HeadLine());
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest request, HttpServletResponse response) {
        return headLineService.modifyHeadLine(new HeadLine());
    }

    public Result<HeadLine> getHeadLineById(HttpServletRequest request, HttpServletResponse response) {
        return headLineService.queryHeadLineById(1);
    }

    public Result<List<HeadLine>> getHeadLineList(HttpServletRequest request, HttpServletResponse response) {
        return headLineService.queryHeadLine(null, 1, 100);
    }

}
