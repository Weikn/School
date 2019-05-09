package org.aweikn.string;// 2019/4/26


import org.junit.Test;

public class LeaingString01 {


    @Test
    public void  testStringApi(){

        String  str  = new String("aebdc");

        String  str1 = "aebdc";

        System.out.println(str.compareTo(str1));


        System.out.println(new String (new char[]{'a','b','c','d'},0,2));
    }

}
