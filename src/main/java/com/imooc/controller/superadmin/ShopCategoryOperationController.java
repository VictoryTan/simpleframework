package com.imooc.controller.superadmin;

import com.imooc.entity.bo.ShopCategory;
import com.imooc.entity.dto.Result;
import com.imooc.service.solo.ShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:
 * @author: air
 * @create: 2020-03-14 11:30
 */
public class ShopCategoryOperationController {
    private ShopCategoryService shopCategoryService;


    public Result<Boolean> addShopCategory(HttpServletRequest request, HttpServletResponse response) {
        return shopCategoryService.addShopCategory(new ShopCategory());
    }

    public Result<Boolean> removeShopCategory(HttpServletRequest request, HttpServletResponse response) {
        return shopCategoryService.removeShopCategory(new ShopCategory());
    }

    public Result<Boolean> modifyShopCategory(HttpServletRequest request, HttpServletResponse response) {
        return shopCategoryService.modifyShopCategory(new ShopCategory());
    }

    public Result<ShopCategory> getShopCategoryById(HttpServletRequest request, HttpServletResponse response) {
        return shopCategoryService.getShopCategoryById(1);
    }

    public Result<List<ShopCategory>> getShopCategoryList(HttpServletRequest request, HttpServletResponse response) {
        return shopCategoryService.getShopCategoryList(null, 1, 100);
    }
    
    

}
