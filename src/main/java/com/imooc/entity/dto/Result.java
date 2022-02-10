package com.imooc.entity.dto;


import lombok.Data;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
@Data
public class Result<T> {

    private int code;

    private String message;

    private T data;


}
