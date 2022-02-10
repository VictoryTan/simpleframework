package com.imooc.service.combine;

import com.imooc.entity.dto.MainPageInfoDto;
import com.imooc.entity.dto.Result;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDto> getMainPageInfo();
}
