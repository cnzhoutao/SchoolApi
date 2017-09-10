package com.zt.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * md5加密，并用base64转成明文
     * @param meassge
     * @return
     */
    public static   String md5(String meassge){
        try {
            MessageDigest md=MessageDigest.getInstance("md5");
            byte md5[]=md.digest(meassge.getBytes());
            BASE64Encoder encoder=new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
