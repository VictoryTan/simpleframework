package com.imooc.controller.frontend;

import com.imooc.entity.dto.MainPageInfoDto;
import com.imooc.entity.dto.Result;
import com.imooc.org.simpleframework.core.annotation.Controller;
import com.imooc.org.simpleframework.inject.annotation.Autowired;
import com.imooc.service.combine.HeadLineShopCategoryCombineService;
import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: air
 * @create: 2020-03-14 11:22
 */
@Controller
@Getter
public class MainPageController {

    @Autowired
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDto> getMainPageInfo(HttpServletRequest request, HttpServletResponse response) {
        return headLineShopCategoryCombineService.getMainPageInfo();
    }

}
