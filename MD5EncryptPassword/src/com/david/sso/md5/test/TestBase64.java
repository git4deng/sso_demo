package com.david.sso.md5.test;

import java.util.Base64;

import com.david.sso.md5.util.MD5Code;

public class TestBase64 {
	public static void main(String[] args) {
		String str="david_java";//ԭʼ��ֵ
		byte[] encode = Base64.getEncoder().encode(str.getBytes());
		String salt = new String(encode);
		System.out.println(salt);
		//���Լ��ܺ������,ʵ�ʿ�������ע���û�ʱ�����ɵļ�������������ݿ⣬��֤cas���ܺʹ����ݿ�ʱ�ļ���Ҫһ��
		String password = "java";
		String newPassword = password + "{{" + salt + "}}";
		for (int x = 0 ; x < 3 ; x ++) {
			newPassword = new MD5Code().getMD5ofStr(newPassword) ;
		}
		System.out.println(newPassword);
	}
}
