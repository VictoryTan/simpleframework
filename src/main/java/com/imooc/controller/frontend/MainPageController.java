package com.imooc.controller.frontend;

import com.imooc.entity.dto.MainPageInfoDto;
import com.imooc.entity.dto.Result;
import com.imooc.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: air
 * @create: 2020-03-14 11:22
 */
public class MainPageController {
    private HeadLineShopCategoryCombineService iHeadLineShopCategoryCombineService;

    public Result<MainPageInfoDto> getMainPageInfo(HttpServletRequest request, HttpServletResponse response) {
        return iHeadLineShopCategoryCombineService.getMainPageInfo();
    }

}
