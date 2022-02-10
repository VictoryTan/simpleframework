package com.imooc.demo.annotation;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/10
 * @Version: 1.0
 */
@CourseInfoAnnotation(courseName="haha",cousrTag = "tag",courseIndex = 12 )
public class ImoocCourse {

    @PersonInfoAnnotation(name = "air",gender = "nan",language = {"c++","java","python"})
    private String author;

    @CourseInfoAnnotation(courseName="haha",cousrTag = "tag",courseIndex = 12)
    public void getCourseInfo(){

    }

}
