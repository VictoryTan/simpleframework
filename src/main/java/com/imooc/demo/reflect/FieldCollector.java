package com.imooc.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
public class FieldCollector {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class reflectTargetClass = Class.forName("com.imooc.demo.reflect.ReflectTarget");
        //获取所有公有字段
        Field[] fields = reflectTargetClass.getFields();
        for (Field field : fields) {
            System.out.println(field);

        }
        //获取所有字段
        Field[] declaredFields = reflectTargetClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        //获取单个公有的field
        Field field = reflectTargetClass.getField("name");
        System.out.println(field);

        //获取私有的field
        Field targetInfo = reflectTargetClass.getDeclaredField("targetInfo");
        System.out.println(targetInfo);
        ReflectTarget reflectTarget = (ReflectTarget) reflectTargetClass.getConstructor().newInstance();
        targetInfo.setAccessible(true);
        targetInfo.set(reflectTarget,"待反射一号");
        System.out.println(targetInfo);

    }
}
