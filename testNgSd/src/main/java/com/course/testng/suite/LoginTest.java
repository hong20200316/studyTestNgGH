package com.course.testng.suite;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by liyanhong on 2020/3/13.
 */
@Test(groups = "function")
public class LoginTest {

    @Test
    @Parameters({"name","password"})
    public void login(String name,int password){
        System.out.println(name+"登录成功！"+"密码是"+password);
    }

}
