package com.imooc.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/9
 * @Version: 1.0
 */
@Data
public class ShopCategory {

    private Long shopCategoryId;
    private String shopCategoryIdName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private String lineImg;
    // 优先级
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
