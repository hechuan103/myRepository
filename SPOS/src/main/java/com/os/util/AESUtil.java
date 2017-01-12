package com.os.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * @title AES 加密算法
 * @author HC
 * @date 2016-12-28上午11:33:12
 * @class AESUtil
 * @package mybatisUtil
 * @project SPOS
 * @describe 
 *
 */
public class AESUtil {

	private static String password = "HCH";
	/** 
	 * 加密 
	 * @param content 需要加密的内容 
	 * @param password  加密密码  //指定密钥
	 * @return 
	 */  
	public static String encrypt(String content) {  
		try {             
			KeyGenerator kgen = KeyGenerator.getInstance("AES");  
			kgen.init(128, new SecureRandom(password.getBytes()));  
			SecretKey secretKey = kgen.generateKey();  
			byte[] enCodeFormat = secretKey.getEncoded();  
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
			byte[] byteContent = content.getBytes("utf-8");  
			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
			byte[] result = cipher.doFinal(byteContent); 
			return parseByte2HexStr(result); // 加密  
		} catch (NoSuchAlgorithmException e) {  
			e.printStackTrace();  
			return null;  
		} catch (NoSuchPaddingException e) {  
			e.printStackTrace(); 
			return null;  
		} catch (InvalidKeyException e) {  
			e.printStackTrace();  
			return null;  
		} catch (UnsupportedEncodingException e) {  
			e.printStackTrace();  
			return null;  
		} catch (IllegalBlockSizeException e) {  
			e.printStackTrace(); 
			return null;  
		} catch (BadPaddingException e) {  
			e.printStackTrace();  
			return null;  
		}  
		
	}


	/**解密 
	 * @param content  待解密内容 
	 * @param password 解密密钥 
	 * @return 
	 */  
	public static String decrypt(String encryptStr) {  
		try {
			
			byte[] content = parseHexStr2Byte(encryptStr); 
			KeyGenerator kgen = KeyGenerator.getInstance("AES");  
			kgen.init(128, new SecureRandom(password.getBytes()));  
			SecretKey secretKey = kgen.generateKey();  
			byte[] enCodeFormat = secretKey.getEncoded();  
			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
			Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化  
			byte[] result = cipher.doFinal(content);  
			return new String(result); // 加密  
		} catch (NoSuchAlgorithmException e) {  
			e.printStackTrace();  
			return null;
		} catch (NoSuchPaddingException e) {  
			e.printStackTrace();
			return null;
		} catch (InvalidKeyException e) {  
			e.printStackTrace();  
			return null;
		} catch (IllegalBlockSizeException e) {  
			e.printStackTrace();  
			return null;
		} catch (BadPaddingException e) {  
			e.printStackTrace(); 
			return null;
		} 
	}

	/**将二进制转换成16进制 
	 * @param buf 
	 * @return 
	 */  
	public static String parseByte2HexStr(byte buf[]) {  
		StringBuffer sb = new StringBuffer();  
		for (int i = 0; i < buf.length; i++) {  
			String hex = Integer.toHexString(buf[i] & 0xFF);  
			if (hex.length() == 1) {  
				hex = '0' + hex;  
			}  
			sb.append(hex.toUpperCase());  
		}  
		return sb.toString();  
	}


	/**将16进制转换为二进制 
	 * @param hexStr 
	 * @return 
	 */  
	public static byte[] parseHexStr2Byte(String hexStr) {  
		if (hexStr.length() < 1)  
			return null;  
		byte[] result = new byte[hexStr.length()/2];  
		for (int i = 0;i< hexStr.length()/2; i++) {  
			int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
			int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
			result[i] = (byte) (high * 16 + low);  
		}  
		return result;  
	}  


	//测试
	public static void main(String[] args) {

		String content = "test";  //391DBEF58AA2E75D6EEB2FDF876D6ACA
		//String password = "ABBCC";//73C58BAFE578C59366D8C995CD0B9D6D  
		//加密  
		System.out.println("加密前：" + content);  
		String encryptResultStr = encrypt(content);  
		System.out.println("加密后：" + encryptResultStr);  
		//解密  
		String decryptResult = decrypt(encryptResultStr);  
		System.out.println("解密后：" + decryptResult);  

	}

}
