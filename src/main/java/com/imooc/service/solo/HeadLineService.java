package com.imooc.service.solo;

import com.imooc.entity.bo.HeadLine;
import com.imooc.entity.dto.Result;

import java.util.List;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
public interface HeadLineService {

    Result<Boolean> addHeadLine(HeadLine headLine);
    Result<Boolean> removeHeadLine(HeadLine headLine);
    Result<Boolean> modifyHeadLine(HeadLine headLine);
    Result<HeadLine> queryHeadLineById(int headLineId);
    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition,int pageIndex,int pageSize);

}
