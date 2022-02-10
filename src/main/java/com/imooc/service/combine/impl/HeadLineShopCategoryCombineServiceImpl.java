package com.imooc.service.combine.impl;

import com.imooc.entity.bo.HeadLine;
import com.imooc.entity.bo.ShopCategory;
import com.imooc.entity.dto.MainPageInfoDto;
import com.imooc.entity.dto.Result;
import com.imooc.service.combine.HeadLineShopCategoryCombineService;
import com.imooc.service.solo.HeadLineService;
import com.imooc.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {
    private HeadLineService headLineService;
    private ShopCategoryService shopCategoryService;


    @Override
    public Result<MainPageInfoDto> getMainPageInfo() {
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineList = headLineService.queryHeadLine(headLineCondition, 1, 4);
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryList = shopCategoryService.getShopCategoryList(shopCategoryCondition, 1, 100);
        //合并两者并返回
        Result<MainPageInfoDto> mainPageInfoDtoResult = mergeMainPageInfoResult(headLineList, shopCategoryList);
        return mainPageInfoDtoResult;
    }

    private Result<MainPageInfoDto> mergeMainPageInfoResult(Result<List<HeadLine>> headLineList, Result<List<ShopCategory>> shopCategoryList) {
        MainPageInfoDto mainPageInfoDto=new MainPageInfoDto();
        mainPageInfoDto.setHeadLineList(headLineList.getData());
        mainPageInfoDto.setShopCategoryList(shopCategoryList.getData());
        Result<MainPageInfoDto> result=new Result();
        result.setData(mainPageInfoDto);
        return result;
    }
}
