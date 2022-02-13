package com.imooc.demo.pattern.singleton;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/13
 * @Version: 1.0
 */
public class StarvingSingleton {

    private static final StarvingSingleton starvingSingleton = new StarvingSingleton();

    private StarvingSingleton() {
    }

    public static StarvingSingleton getInstance() {
        return starvingSingleton;
    }

}
