package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by liyanhong on 2020/3/14.
 */
public class expextedExceptionAnnotation {

    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExpexted(){
        System.out.println("运行异常测试");
        throw new RuntimeException();
    }

}
