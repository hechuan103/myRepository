package com.os.util;

/**
 * 
 * @title 验证加密数据
 * @author HC
 * @date 2016-12-28下午2:28:30
 * @class CheckEncrypt
 * @package com.os.util
 * @project SPOS
 * @describe 
 *
 */
public class CheckAndMakeEncrypt {
	
	//密码校验
	public static boolean checkPassword(String inputPassword,String selectPassword){
		String dataBasePassword = AESUtil.decrypt(selectPassword);
		return inputPassword.equals(dataBasePassword);
	}
	
	//信息加密
	public static String encryptInfo(String encryptStr){
		return 	AESUtil.encrypt(encryptStr);
	}

}
