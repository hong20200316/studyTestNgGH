package com.course.testng;


import org.testng.annotations.*;

/**
 * Created by liyanhong on 2020/3/13.
 */
@Test(groups = "base")
public class BaseAnnotation {

    @Test(enabled = true)
    public void testCase1() {
        System.out.println("testcase1");

    }

    @Test
    public void testCase2() {
        System.out.println("testcase2");
    }

    //忽略测试 @Test = @Test(enabled=true) 不被忽略
    @Test
    public void ignore1() {
        System.out.println("忽略测试case1");
    }

    //enabled=false 则被忽略
    @Test(enabled = true)
    public void ignore2() {
        System.out.println("忽略测试case2");
    }

    @Test(enabled = true)
    public void ignore3() {
        System.out.println("忽略测试case3");
    }

    @Test(enabled = false)
    @BeforeMethod
    public void beforeTest() {
        System.out.println("beforemethod");

    }

    @Test(enabled = false)
    @AfterMethod
    public void afterTest() {
        System.out.println("aftermethod");
    }

    @Test(enabled = false)
    @AfterClass
    public void classAfter() {
        System.out.println("Afterclass");
    }

    @Test(enabled = false)
    @BeforeClass
    public void beforeclass() {
        System.out.println("beforeclass");
    }

    //套件测试配合suite.xml
    @Test(enabled = false)
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforesuite套件");
    }

    @Test(enabled = false)
    @AfterSuite
    public void afterSuite() {
        System.out.println("aftersuite套件");
    }


    //分组测试
    @Test(groups = "server")
    public void serverGroup1() {
        System.out.println("server组1");
    }

    @Test(groups = "server")
    public void servergroup2() {
        System.out.println("server组2");
    }

    @Test(groups = "client")
    public void clientGroup1() {
        System.out.println("client组1");
    }

    @Test(groups = "client")
    public void clientGroup2(){
        System.out.println("client组2");
    }

    @BeforeGroups("server")
    public void befogroup(){
        System.out.println("server组之前执行");
    }
    @AfterGroups("server")
    public void aftergroup(){
        System.out.println("server组之后执行");
    }
    @BeforeGroups("client")
    public void clientbefogroup(){
        System.out.println("client组之前执行");
    }
    @AfterGroups("client")
    public void clientaftergroup(){
        System.out.println("client组之后执行");
    }


}
