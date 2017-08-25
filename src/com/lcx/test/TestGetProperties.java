package com.lcx.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 读取类路径下的属性配置文件
 * @author 39054
 *
 */
public class TestGetProperties {

	public static void main(String[] args) throws Exception {
		URL url =TestGetProperties.class.getResource("");
		System.out.println(url.getPath());
		InputStream is = new FileInputStream(url.getPath()+"OA-NJB01201.properties");
		Properties ps = new Properties();
		ps.load(is);
		Map<String,String> map = new HashMap(ps);
		Set<String>  set =map.keySet();
		for(String key :set){
			System.out.println(key+"====="+map.get(key));
		}
		
	}
}
