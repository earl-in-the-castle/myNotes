package com.lcx.test;

public class TestGetResource1 {


    public static void main(String[] args)
    {
        System.out.println(TestGetResource1.class.getResource(""));
        System.out.println(TestGetResource1.class.getResource("/"));
        
        System.out.println(TestGetResource1.class.getClassLoader().getResource(""));
        System.out.println(TestGetResource1.class.getClassLoader().getResource("/"));
    }


}
