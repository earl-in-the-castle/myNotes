package com.lcx.string;

public class TestString {

	public static void main(String[] args) {
		//����string ��split����
		String [] stringArr;
		String s="asdfghjkl";
		stringArr=s.split("g");
		for (int i = 0; i < stringArr.length; i++) {
			System.out.println(stringArr[i]+"   ");
		}
	}
}
