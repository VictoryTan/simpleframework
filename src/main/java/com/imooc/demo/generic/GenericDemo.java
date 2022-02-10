package com.imooc.demo.generic;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/9
 * @Version: 1.0
 */
public class GenericDemo {

    public static void handleMember( GenericClassExample<? extends Number> integerExample){
        Integer result = 1111+ (Integer) integerExample.getMember();
        System.out.println("result is " + result);
    }

    public static void main(String[] args) {
        GenericClassExample<String> stringExample = new GenericClassExample<String>("abc");
        GenericClassExample<Integer> integerExample = new GenericClassExample<Integer>(111);
        System.out.println(stringExample.getMember());
        System.out.println(integerExample.getMember());
        integerExample.handleSomething(2131);
        handleMember(integerExample);
    }
}
