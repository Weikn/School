package org.aweikn.spring.aop;// 2019/4/24

import org.aweikn.spring.ioc.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopMain {

    public static void main(String[] args) {
        System.out.println("test aop main start .");

        ApplicationContext context  =  new ClassPathXmlApplicationContext(new  String[]{"applicationContext.xml"});

        User user  = (User) context.getBean("user");

        System.out.println(user.toString());

        LoginService  longin  = (LoginService) context.getBean("login");

        longin.login();

    }
}
