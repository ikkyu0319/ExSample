package com.androidex.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密帮助类
 */
public class MD5Util {

    private char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest messageDigest = null;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static MD5Util self = null;

    private MD5Util() {
    }

    public static MD5Util getInstance() {
        if (self == null) {
            self = new MD5Util();
        }
        return self;
    }

    private String md5(String s) {

        try {
            byte[] strTemp = s.getBytes();
            messageDigest.update(strTemp);
            byte[] md = messageDigest.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取Qyer登陆加密串
     *
     * @param username
     * @param pwd
     * @return
     */
    public String getAccountS(String username, String pwd) {
        String temp = username.substring(0, 2) + pwd.substring(0, 2)
                + username.substring(username.length() - 2, username.length())
                + pwd.substring(pwd.length() - 2, pwd.length());


        return md5(md5(temp).toLowerCase()).toLowerCase();
    }

    /**
     * 计算文件的MD5
     *
     * @param fileName 文件的绝对路径
     * @return
     * @throws IOException
     */
    public String getFileMD5String(String fileName) throws IOException {
        File f = new File(fileName);
        return getFileMD5String(f);
    }

    /**
     * 计算文件的MD5，重载方法
     *
     * @param file 文件对象
     * @return
     * @throws IOException
     */
    public String getFileMD5String(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        FileChannel ch = in.getChannel();
        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
                file.length());
        messageDigest.update(byteBuffer);
        return bufferToHex(messageDigest.digest());
    }

    private String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

}
