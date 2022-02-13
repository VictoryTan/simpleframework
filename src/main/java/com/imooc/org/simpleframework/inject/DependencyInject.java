package com.imooc.org.simpleframework.inject;

import com.imooc.org.simpleframework.core.BeanContainer;
import com.imooc.org.simpleframework.inject.annotation.Autowired;
import com.imooc.org.simpleframework.util.ClassUtil;
import com.imooc.org.simpleframework.util.ValidationUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/13
 * @Version: 1.0
 */
@Slf4j
public class DependencyInject {

    private BeanContainer beanContainer;

    public DependencyInject() {
        beanContainer = BeanContainer.getInstance();
    }

    public void doIoc() {
        if (ValidationUtil.isEmpty(beanContainer.getClasses())) {
            log.warn("容器为空...");
            return;
        }
        for (Class<?> clazz : beanContainer.getClasses()) {
            Field[] fields = clazz.getDeclaredFields();
            if (ValidationUtil.isEmpty(fields)) {
                continue;
            }
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Autowired annotation = field.getAnnotation(Autowired.class);
                    String value = annotation.value();
                    // 获取成员成员变量的类型
                    Class<?> fieldClass = field.getType();
                    Object fieldValue = getFieldInstance(fieldClass, value);
                    if (fieldValue == null) {
                        throw new RuntimeException("没有找到对应实例："+fieldValue.toString());
                    }else {
                        Object targetBean=beanContainer.getBean(clazz);
                        ClassUtil.setField(field,targetBean,fieldValue,true);
                    }
                }
            }
        }
    }

    private Object getFieldInstance(Class<?> fieldClass, String value) {
        Object fieldValue = beanContainer.getBean(fieldClass);
        if (fieldValue != null) {
            return fieldValue;
        } else {
            Class<?> implementedClass = getImplementedClass(fieldClass, value);
            if (implementedClass != null) {
                return beanContainer.getBean(implementedClass);
            } else {
                return null;
            }
        }
    }

    private Class<?> getImplementedClass(Class<?> fieldClass, String value) {
        Set<Class<?>> classSet = beanContainer.getClassesBySuper(fieldClass);
        if (ValidationUtil.isEmpty(classSet)) {
            if (ValidationUtil.isEmpty(value)) {
                if (classSet.size() == 1) {
                    return classSet.iterator().next();
                } else {
                    throw new RuntimeException("接口存在多个实现类，您需要指定@Autowired(value) 具体类：" + fieldClass.getName());
                }
            } else {
                for (Class<?> c : classSet) {
                    if (value.equals(c.getSimpleName())) {
                        return c;
                    }
                }
            }
        }

        return null;
    }
}
