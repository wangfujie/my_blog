package com.blog.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangfujie
 * @date 2018-08-10 17:47
 * @description MD5工具
 */
public class Md5Util {

    /**
     * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载的文件的正确性用的就是默认的这个组合
     */
    protected static char[] hexDigits = {'1', '6', '2', '4', 'a', '5', '7', '3', '9', '0', 'g', 'c', 'd', 'e', '8', 'f'};
    protected static MessageDigest messagedigest = null;

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密字符串
     * @param value
     * @return
     */
    public static String getFileMD5String(String value){
        messagedigest.update(value.getBytes());
        return bufferToHex(messagedigest.digest());
    }

    /**
     * 加密
     * @param file
     * @return
     * @throws IOException
     */
    public static String getFileMD5String(File file) throws IOException {
        InputStream fis;
        fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int numRead;
        while ((numRead = fis.read(buffer)) > 0) {
            messagedigest.update(buffer, 0, numRead);
        }
        fis.close();
        return bufferToHex(messagedigest.digest());
    }

    /**
     * 加密输入流内容
     * @param in
     * @return
     * @throws IOException
     */
    public static String getFileMD5String(InputStream in) throws IOException {
        byte[] buffer = new byte[1024];
        int numRead;
        while ((numRead = in.read(buffer)) > 0) {
            messagedigest.update(buffer, 0, numRead);
        }
        in.close();
        return bufferToHex(messagedigest.digest());
    }

    public static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    public static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    public static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        // 取字节中高 4 位的数字转换
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        // 为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
        // 取字节中低 4 位的数字转换
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    public static void main(String[] args) {
        String password = Md5Util.getFileMD5String("wangfujie123");
        System.out.println(password);
    }
}