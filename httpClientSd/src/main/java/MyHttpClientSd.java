import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by liyanhong on 2020/3/16.
 */
public class MyHttpClientSd {


    private ResourceBundle bundle;
    private String url;

    BasicCookieStore cookieStore = new BasicCookieStore();


    @BeforeMethod
    public void getProperties(){

        //获取properties文件中的参数
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("client.url");

    }

    //调用接口获取返回值信息
    @Test
    public void myHttpClientMethod() throws IOException {

        String result;
        HttpGet get = new HttpGet("http://localhost:8899/demo");
        HttpClient client =  HttpClientBuilder.create().build();

        HttpResponse response = client.execute(get);
        HttpEntity responseEntity = response.getEntity();
        result = EntityUtils.toString(response.getEntity());


        System.out.println("----------------");
        System.out.println(responseEntity);
        System.out.println(result);
        System.out.println("----------------");

    }

    //获取接口中返回的cookie信息
    @Test
    public void myCookieGet(){

        HttpResponse response;
        String uri;
        uri = bundle.getString("client.uri");


        HttpGet get = new HttpGet(url+uri);

        HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();

        try {
            //发动get请求
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取返回的cookies信息
        List<Cookie> cookieList;
        cookieList = cookieStore.getCookies();
        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookiesName = "+name +" ;cookiesValue = "+value);
        }


    }

    //
    @Test(dependsOnMethods = "myCookieGet")
    public void paraCookies(){

        String uri;
        String result;
        HttpResponse response;
        uri = bundle.getString("client.uri.getCookie");



        HttpGet get = new HttpGet(url+uri);
        HttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        try {
             response = client.execute(get);
             result = EntityUtils.toString(response.getEntity());
             System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





}
