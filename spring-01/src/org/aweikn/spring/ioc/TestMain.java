package org.aweikn.spring.ioc;// 2019/4/24

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        System.out.println("test spring start .");

        ApplicationContext  context  = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        User user = (User) context.getBean("user");

        System.out.println(user);

    }
}
