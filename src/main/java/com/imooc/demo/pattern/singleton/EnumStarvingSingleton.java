package com.imooc.demo.pattern.singleton;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/13
 * @Version: 1.0
 */
public class EnumStarvingSingleton {

    private EnumStarvingSingleton() {

    }

    public static EnumStarvingSingleton getInstance(){
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder {

        HOLDER;
        private EnumStarvingSingleton instance;

        ContainerHolder() {
            instance = new EnumStarvingSingleton();
        }

    }

}
