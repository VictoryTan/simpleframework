package org.simpleFramework.util.inject;


import com.imooc.controller.frontend.MainPageController;
import com.imooc.org.simpleframework.core.BeanContainer;
import com.imooc.org.simpleframework.inject.DependencyInject;
import org.junit.jupiter.api.*;

/**
 * @description:
 * @author: air
 * @create: 2020-03-16 15:51
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DoIocTest {

    @Test
//    @DisplayName("doIoc")
    public void doIoc() {
        BeanContainer beanContainer = BeanContainer.getInstance();

        beanContainer.loadBeans("com.imooc");
        Assertions.assertEquals(true, beanContainer.isLoading());

        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        Assertions.assertEquals(true, mainPageController instanceof MainPageController);

        Assertions.assertEquals(null, mainPageController.getHeadLineShopCategoryCombineService());

        new DependencyInject().doIoc();
        Assertions.assertNotEquals(null, mainPageController.getHeadLineShopCategoryCombineService());


    }

}
