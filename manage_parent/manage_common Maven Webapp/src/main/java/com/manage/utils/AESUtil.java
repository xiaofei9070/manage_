package com.manage.utils;


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

public class AESUtil {
	
	
	 public static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            kgen.init(128, new SecureRandom(password.getBytes()));

            SecretKey secretKey = kgen.generateKey();

            byte[] enCodeFormat = secretKey.getEncoded();

            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

            Cipher cipher = Cipher.getInstance("AES");

            byte[] byteContent = content.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] result = cipher.doFinal(byteContent);

            return result;

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
	 }
	 public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);  
            return result; 
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
	 
	 public static void main(String[] args) {
		 String content = "美女，约吗？啊啊啊啊啊啊啊啊啊啊啊啊啊阿啊啊啊啊啊啊啊啊阿啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊阿啊啊啊啊啊啊啊啊阿啊啊啊啊";
	        String password = RandomKeyUtil.getDefaultKey();
	        System.out.println("加密之前：" + content);
	        System.out.println("加密：" + System.currentTimeMillis());
	        // 加密
	        byte[] encrypt = AESUtil.encrypt(content, password);
	        System.out.println("加密：" + System.currentTimeMillis());
	        System.out.println("加密后的内容：" + new String(encrypt));
	        
	        //如果想要加密内容不显示乱码，可以先将密文转换为16进制
	        String hexStrResult = ParseSystemUtil.parseByte2HexStr(encrypt);
	        System.out.println("16进制的密文："  + hexStrResult);
	        
	        //如果的到的是16进制密文，别忘了先转为2进制再解密
	        byte[] twoStrResult = ParseSystemUtil.parseHexStr2Byte(hexStrResult);
	              
	        // 解密
	        System.out.println("解密：" + System.currentTimeMillis());
	        byte[] decrypt = AESUtil.decrypt(twoStrResult, password);
	        System.out.println("解密：" + System.currentTimeMillis());
	        System.out.println("解密后的内容：" + new String(decrypt));       
	    }
}
