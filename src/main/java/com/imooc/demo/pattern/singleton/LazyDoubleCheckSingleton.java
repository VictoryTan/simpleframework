package com.imooc.demo.pattern.singleton;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/13
 * @Version: 1.0
 */
public class LazyDoubleCheckSingleton {

    private LazyDoubleCheckSingleton(){

    }
    private static volatile LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    public static LazyDoubleCheckSingleton getInstance(){
        if (lazyDoubleCheckSingleton == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (lazyDoubleCheckSingleton == null){
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
