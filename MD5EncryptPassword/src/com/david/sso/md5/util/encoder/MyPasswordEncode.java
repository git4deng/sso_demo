package com.david.sso.md5.util.encoder;

import java.util.Base64;

import org.jasig.cas.authentication.handler.PasswordEncoder;

import com.david.sso.md5.util.MD5Code;
/**
 * cas-server-core-api-4.1.7.jar 此jar在cas的lib下，所以打包的时候不需要将此包一起打进去，此jar包可能与不同的
 * cas版本有一定的区别
 * @author david
 *
 */
public class MyPasswordEncode implements PasswordEncoder{

	@Override
	public String encode(String password) {
		String str="david_java";//原始盐值
		byte[] encode = Base64.getEncoder().encode(str.getBytes());
		String salt = new String(encode);//加密过后得盐值
		//利用md5加密3次
		String newPassword = password + "{{" + salt + "}}";
		for (int x = 0 ; x < 3 ; x ++) {
			newPassword = new MD5Code().getMD5ofStr(newPassword) ;
		}
		return newPassword;
	}

}
