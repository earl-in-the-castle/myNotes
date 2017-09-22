package com.lcx.genxml;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class GenXML {

	public static void main(String[] args) {
		String fileName="template.vm";
		Map<String,String> map = new HashMap<String,String>();
		map.put("ref", "123456");
		/*map.put("aaa", "");*/
        URL url = GenXML.class.getResource("");
    	
      
        try {
			String resultXml=FreeMarkerUtil.transformString(url.getPath().substring(1)+fileName, map);
			System.out.println(resultXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
