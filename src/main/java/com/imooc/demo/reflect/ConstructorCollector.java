package com.imooc.demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
public class ConstructorCollector {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.imooc.demo.reflect.ReflectTarget");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor declaredConstructor = clazz.getDeclaredConstructor(int.class);
        System.out.println(declaredConstructor);
        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance(12);
    }
}
