package com.david.sso.md5.util.encoder;

import java.util.Base64;

import org.jasig.cas.authentication.handler.PasswordEncoder;

import com.david.sso.md5.util.MD5Code;
/**
 * cas-server-core-api-4.1.7.jar ��jar��cas��lib�£����Դ����ʱ����Ҫ���˰�һ����ȥ����jar�������벻ͬ��
 * cas�汾��һ��������
 * @author david
 *
 */
public class MyPasswordEncode implements PasswordEncoder{

	@Override
	public String encode(String password) {
		String str="david_java";//ԭʼ��ֵ
		byte[] encode = Base64.getEncoder().encode(str.getBytes());
		String salt = new String(encode);//���ܹ������ֵ
		//����md5����3��
		String newPassword = password + "{{" + salt + "}}";
		for (int x = 0 ; x < 3 ; x ++) {
			newPassword = new MD5Code().getMD5ofStr(newPassword) ;
		}
		return newPassword;
	}

}
