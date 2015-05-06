package com.androidex.utils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;

/**
 * 文件相关操作
 */
public class FileUtil {

  private static final String TAG = FileUtil.class.getSimpleName();

  /**
   * 文件的复制
   */
  public static void fileChannelCopy(File s, File t) {
    FileInputStream fi = null;
    FileOutputStream fo = null;
    try {
      fi = new FileInputStream(s);
      fo = new FileOutputStream(t);
      FileChannel in = fi.getChannel();//得到对应的文件通道
      FileChannel out = fo.getChannel();//得到对应的文件通道
      in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fo != null) fo.close();
        if (fi != null) fi.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 获取文件对应值的大小
   *
   * @param fileLen 字节数
   */
  public static String formatFileSizeToString(long fileLen) {// 转换文件大小
    DecimalFormat df = new DecimalFormat("#.00");
    String fileSizeString = "";
    if (fileLen < 1024) {
      fileSizeString = df.format((double) fileLen) + "B";
    } else if (fileLen < 1048576) {
      fileSizeString = df.format((double) fileLen / 1024) + "K";
    } else if (fileLen < 1073741824) {
      fileSizeString = df.format((double) fileLen / 1048576) + "M";
    } else {
      fileSizeString = df.format((double) fileLen / 1073741824) + "G";
    }
    return fileSizeString;
  }

  /**
   * 根据文件路径删除 单个文件
   */
  public boolean deleteFile(String sPath) {
    
    boolean flag = false;
    File file = new File(sPath);
    if (file.isFile() && file.exists()) {// 路径为文件且不为空则进行删除
      file.delete();
      flag = true;
    }
    return flag;
  }

  /**
   * 删除整个文件夹
   *
   * @param dir 文件夹
   * @param curTime System.currentTimeMillis()
   */
  private int clearCacheFolder(File dir, long curTime) {

    int deletedFiles = 0;
    if (dir != null && dir.isDirectory()) {
      try {
        for (File child : dir.listFiles()) {
          if (child.isDirectory()) {
            deletedFiles += clearCacheFolder(child, curTime);
          }
          if (child.lastModified() < curTime) {
            if (child.delete()) {
              deletedFiles++;
            }
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return deletedFiles;
  }

  /**
   * 获取文件扩展名
   *
   * @return 返回文件扩展名
   */
  public static String getExtensionName(String filename) {
    if ((filename != null) && (filename.length() > 0)) {
      int dot = filename.lastIndexOf('.');
      if ((dot > -1) && (dot < (filename.length() - 1))) {
        return filename.substring(dot + 1);
      }
    }
    return filename;
  }

  /**
   * 读取指定文件的输出
   */
  public static String getFileOutputString(String path) {
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(path), 8192);
      StringBuilder sb = new StringBuilder();
      String line = null;
      while ((line = bufferedReader.readLine()) != null) {
        sb.append("\n").append(line);
      }
      bufferedReader.close();
      return sb.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
