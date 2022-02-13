package com.imooc.org.simpleframework.core;

import com.imooc.org.simpleframework.core.annotation.Component;
import com.imooc.org.simpleframework.core.annotation.Controller;
import com.imooc.org.simpleframework.core.annotation.Repository;
import com.imooc.org.simpleframework.core.annotation.Service;
import com.imooc.org.simpleframework.util.ClassUtil;
import com.imooc.org.simpleframework.util.ValidationUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @author: tanshiwei
 * @date: 2022/2/13
 * @Version: 1.0
 */
@Slf4j
public class BeanContainer {

    private BeanContainer() {
    }

    public static BeanContainer getInstance() {
        return ContainerHolder.HOLDER.instance;
    }

    public enum ContainerHolder {

        HOLDER;

        private BeanContainer instance;

        ContainerHolder() {
            instance = new BeanContainer();
        }
    }


    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION = Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);

    // 容器是否被加载过
    private boolean loading = false;

    public synchronized void loadBeans(String packageName) {
        if (loading) {
            return;
        }

        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("没有找到相应的包:{}", packageName);
            return;
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> aClass : BEAN_ANNOTATION) {
                if (clazz.isAnnotationPresent(aClass)) {
                    beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
                }
            }
        }
        loading = true;
    }


    public int size() {
        return beanMap.size();
    }

    /**
     * 添加一个class对象及其bean的实例
     *
     * @param clazz
     * @param bean
     * @return
     */
    public Object addBean(Class<?> clazz, Object bean) {
        return beanMap.put(clazz, bean);
    }


    /**
     * 移除一个ioc容器管理的对象
     *
     * @param clazz
     * @return
     */
    public Object removeBean(Class<?> clazz) {
        return beanMap.remove(clazz);
    }

    /**
     * 获取一个bean实例
     *
     * @param clazz
     * @return
     */
    public Object getBean(Class<?> clazz) {
        return beanMap.get(clazz);
    }


    /**
     * 获取容器管理的所有class对象集合
     *
     * @return
     */
    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }

    /**
     * 获取所有bean的集合
     *
     * @return
     */
    public Set<Object> getBeans() {
        return new HashSet<Object>(beanMap.values());
    }


    public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
        Set<Class<?>> aClass = getClasses();
        if (ValidationUtil.isEmpty(aClass)) {
            log.warn("没有任何class对象");
            return null;
        }
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : aClass) {
            if (clazz.isAnnotationPresent(annotation)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

    /**
     * 通过接口或父类获取子类或实现类的集合,不包括本身
     *
     * @param interfaceOrClass
     * @return
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass) {
        Set<Class<?>> keySet = getClasses();
        if (ValidationUtil.isEmpty(keySet)) {
            log.warn("没有任何class对象");
            return null;
        }
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clazz : keySet) {
            if (interfaceOrClass.isAssignableFrom(clazz) && clazz.equals(interfaceOrClass)) {
                classSet.add(clazz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }

    public boolean isLoading() {
        return loading;
    }
}
