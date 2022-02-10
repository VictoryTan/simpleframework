package com.imooc.demo.reflect;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
public class ReflectTarget {

    public String name;
    protected int index;
    char type;
    private String targetInfo;


    public ReflectTarget(String string){
        System.out.println("str = " + string);
    }

    ReflectTarget(char ca){
        System.out.println("ca ="+ ca);
    }
    public ReflectTarget(){
        System.out.println("RelectTarget");
    }

    protected ReflectTarget(Boolean b){
        System.out.println("b = " + b);
    }

    private ReflectTarget(int index){
        System.out.println("index 私有构造方法 = " + index);
    }


    public static void main(String[] args) {
        ReflectTarget reflectTarget = new ReflectTarget();

        Class aClass = reflectTarget.getClass();

        System.out.println(aClass.getName());
        Class bclass = ReflectTarget.class;

        try {
            Class aClass1 = Class.forName("com.imooc.demo.reflect.ReflectTarget");
            String name = aClass1.getName();
            System.out.println(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
