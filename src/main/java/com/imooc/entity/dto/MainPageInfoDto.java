package com.imooc.entity.dto;

import com.imooc.entity.bo.HeadLine;
import com.imooc.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
@Data
public class MainPageInfoDto {

    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
