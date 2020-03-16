package com.course.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by liyanhong on 2020/3/14.
 */
public class DataProviderTest {

    @Test(dataProvider = "dataprovide1")
    public void user1(String name,int age){
        System.out.println("user1姓名"+name+"年龄"+age);
    }

    @Test(dataProvider = "dataprovide2")
    public void user2(String name,int age){
        System.out.println("user2姓名"+name+"年龄"+age);
    }

    @Test(dataProvider = "dataprovide2")
    public void user3(String name,int age){
        System.out.println("user3姓名"+name+"年龄"+age);
    }

    //给一个方法传值
    @DataProvider(name="dataprovide1")
    public Object[][] datas1(){
        Object[][] objects=new Object[][]{
                {"LIYANHONG",30},
                {"DING",32}
        };
        return objects;
    }


    //给多个方法传值
    @DataProvider(name = "dataprovide2")
    public Object[][] datas2(Method method){
        Object[][] o=null;
        System.out.println(method.getReturnType());

        if(method.getName().equals("user2")){
            o=new Object[][]{
                {"小女生",10},
                {"小公主",15}
            };

        }else if (method.getName().equals("user3")){
            o=new Object[][]{
                    {"小男生",11},
                    {"小王子",16}
            };

        };
        return o;

    }
}
