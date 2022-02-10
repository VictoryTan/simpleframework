package com.imooc.service.solo;

import com.imooc.entity.bo.ShopCategory;
import com.imooc.entity.dto.Result;

import java.util.List;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
public interface ShopCategoryService {

    Result<Boolean> addShopCategory(ShopCategory shopCategory);
    Result<Boolean> removeShopCategory(ShopCategory shopCategory);
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);

    Result<ShopCategory> getShopCategoryById(int shopCategoryId);
    Result<List<ShopCategory>> getShopCategoryList(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
