package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by liyanhong on 2020/3/14.
 */
public class MultiThreadOnAnnotation {

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void multiThread(){
        System.out.printf("*************hello world************** Thread Id : %s%n",Thread.currentThread().getId());
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());

    }
}
