package com.lcx.test;

public class TestGetResource2 {


    public static void main(String[] args)
    {
        System.out.println(TestGetResource2.class.getResource(""));
        System.out.println(TestGetResource2.class.getResource("/"));
        
        System.out.println(TestGetResource2.class.getClassLoader().getResource(""));
        System.out.println(TestGetResource2.class.getClassLoader().getResource("/"));
    }


}
