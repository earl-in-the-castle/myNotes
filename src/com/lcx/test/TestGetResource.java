package com.lcx.test;

import java.net.URL;

/**
 * 2017��8��25��15:08:38
 * �������������class�ڻ�ȡ��Դ�ļ���·���Ĳ���
 * @author 39054
 *
 */
public class TestGetResource {


    public static void main(String[] args)
    {
    	
    	URL url = TestGetResource.class.getResource("");
    	
        System.out.println(url.getPath());
        System.out.println(TestGetResource.class.getResource("/"));
        
        System.out.println(TestGetResource.class.getClassLoader().getResource(""));
        System.out.println(TestGetResource.class.getClassLoader().getResource("/"));
        
    }


}
