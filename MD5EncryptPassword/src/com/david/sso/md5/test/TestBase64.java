package com.david.sso.md5.test;

import java.util.Base64;

import com.david.sso.md5.util.MD5Code;

public class TestBase64 {
	public static void main(String[] args) {
		String str="david_java";//原始盐值
		byte[] encode = Base64.getEncoder().encode(str.getBytes());
		String salt = new String(encode);
		System.out.println(salt);
		//测试加密后的密码,实际开发中在注册用户时，生成的加密密码存入数据库，保证cas加密和存数据库时的加密要一致
		String password = "java";
		String newPassword = password + "{{" + salt + "}}";
		for (int x = 0 ; x < 3 ; x ++) {
			newPassword = new MD5Code().getMD5ofStr(newPassword) ;
		}
		System.out.println(newPassword);
	}
}
