package com.imooc.service.solo.impl;

import com.imooc.entity.bo.ShopCategory;
import com.imooc.entity.dto.Result;
import com.imooc.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> getShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> getShopCategoryList(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
