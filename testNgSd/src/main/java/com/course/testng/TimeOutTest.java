package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by liyanhong on 2020/3/14.
 */
public class TimeOutTest {

    @Test(timeOut = 2000)
    public void timeout() throws InterruptedException {
        Thread.sleep(3000);
    }
}
