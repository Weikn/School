package com.aweikn.httpclient.client;// 2019/5/8


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.params.AuthPNames;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {

    public static void main(String[] args) {
        HttpClientTest test  = new HttpClientTest();
//        test.test1();
//        test.test2();
//        test.test3();
        test.test4();
    }

    public void  test1(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet  httpGet = new HttpGet("http://localhost:8089/login?username=guoweikun");

        CloseableHttpResponse response = null;

        try {
             response = httpClient.execute(httpGet);

            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            System.out.println("HttpEntity :" + responseEntity.toString());
            System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


    public  void  test2(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("http://localhost:8089/loginout?username=guoweikun");

        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            System.out.println("HttpEntity :" + responseEntity.toString());
            System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public  void  test3(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY,
                new NTCredentials("user", "pwd", "myworkstation", "microsoft.com"));
        HttpPost httpPost = new HttpPost("http://localhost:8089/loginout?username=guoweikun");
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost,context);
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            System.out.println("HttpEntity :" + responseEntity.toString());
            System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public  void  test4(){

        DefaultHttpClient httpclient = new DefaultHttpClient();
        List<String> authpref = new ArrayList<String>();
        authpref.add(AuthPolicy.NTLM);
        httpclient.getParams().setParameter(AuthPNames.TARGET_AUTH_PREF,    authpref);
        //参数分别为用户名、密码、服务器url、工作域名称
        NTCredentials creds = new NTCredentials("INT_CRM_BSCS", "4azABEaw",     "", "ADCM");
        httpclient.getCredentialsProvider().setCredentials(AuthScope.ANY, creds);

        //设置要连接的目标名称、端口
        HttpHost target = new HttpHost("Microsoft-IIS/8.5", 8094, "http");

        // Make sure the same context is used to execute logically related requests
        HttpContext localContext = new BasicHttpContext();

        // Execute a cheap method first. This will trigger NTLM authentication
//        HttpPost httpget = new HttpPost("http://localhost:8089/loginout?username=guoweikun");
        //下面是为请求加上一些header信息，来伪装浏览器
        HttpPost httpget = new HttpPost("http://172.26.77.158:8094/OpportunityMngt/Opportunity");
        httpget.addHeader("Accept-Language", "zh-Hans-CN,zh-Hans;q=0.8,en-US;q=0.5,en;q=0.3");
        httpget.addHeader("Accept","image/jpeg, application/x-ms-application, image/gif, application/xaml+xml, image/pjpeg, application/x-ms-xbap, */*");
        httpget.addHeader("DNT","1");
        httpget.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpget.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.2; WOW64; Trident/6.0; .NET4.0E; .NET4.0C; .NET CLR 3.5.30729; .NET CLR 2.0.50727; .NET CLR 3.0.30729)");
        httpget.addHeader("Accept-Encoding","gzip, deflate");

        String str= "{ 'id': '8985CBC9-E8FF-E611-80C9-005056A13754', 'quotationId': '222211111111','totalAmount': '12345678'}";
        HttpEntity httpEntity = new StringEntity(str, "utf-8");
        httpget.setEntity(httpEntity);
        try
        {

            HttpResponse response = httpclient.execute(httpget);
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            System.out.println("HttpEntity :" + responseEntity.toString());
            System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
        } catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
