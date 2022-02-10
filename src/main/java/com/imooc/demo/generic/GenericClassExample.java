package com.imooc.demo.generic;

import lombok.Data;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/9
 * @Version: 1.0
 */
@Data
public class GenericClassExample <T> {

    private T member;

    public GenericClassExample(T member) {
        this.member = member;
    }

    public T handleSomething(T target){
        return target;
    }
}
