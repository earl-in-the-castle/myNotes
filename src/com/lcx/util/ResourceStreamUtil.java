package com.lcx.util;

import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

public class ResourceStreamUtil {

	//@Test
	public static Object getResourceStream(String filename) {

		if (filename.startsWith("/")) {
			filename = filename.substring(1);
		}
		InputStream resourceAsStream = ResourceStreamUtil.class
				.getClassLoader().getResourceAsStream(filename);

		return resourceAsStream;

	}
}
