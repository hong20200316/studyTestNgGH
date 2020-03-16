package com.course.testng.suite;

import org.testng.annotations.Test;

/**
 * Created by liyanhong on 2020/3/13.
 */
@Test(groups = "function")
public class PayTest {


    //依赖测试
    @Test(dependsOnMethods = {"com.course.testng.expextedExceptionAnnotation.runtimeExpexted"})
    public void pay(){
        System.out.println("支付成功！");
    }
}
