package com.lcx.test;

public class TestGetResource {


    public static void main(String[] args)
    {
        System.out.println(TestGetResource.class.getResource(""));
        System.out.println(TestGetResource.class.getResource("/"));
        
        System.out.println(TestGetResource.class.getClassLoader().getResource(""));
        System.out.println(TestGetResource.class.getClassLoader().getResource("/"));
    }


}
