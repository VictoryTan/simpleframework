package com.imooc.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
public class AnnotationParser {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.imooc.demo.annotation.ImoocCourse");
        // 这里是获取class对象的注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation) annotation;
            System.out.println(courseInfoAnnotation);
            System.out.println(courseInfoAnnotation.courseName());
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
            boolean hasPersionAnno = field.isAnnotationPresent(PersonInfoAnnotation.class);
            if (hasPersionAnno){
                PersonInfoAnnotation annotation = field.getAnnotation(PersonInfoAnnotation.class);
                System.out.println(annotation.age()+annotation.language().toString());
            }
        }
    }
}
