package com.lcx.test;

import java.net.URL;

/**
 * 2017年8月25日15:08:38
 * 测试类加载器与class在获取资源文件的路径的差异
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
