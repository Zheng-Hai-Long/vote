package com.vote.utils;

import java.nio.charset.Charset;

public interface Constant
{
    Charset GBK = Charset.forName("GBK");
    
    Charset UTF8 = Charset.forName("utf-8");
    
    /**
     * url 路径分隔符   
     */
    String url_separator = "/";
    
    /**
     * url 路径分隔符   
     */
    String file_dian = ".";
    
    /**
     * 数据库，数据默认分隔符
     */
    String data_separator = ",";
    
    /**
     * 图片压缩宽高比
     */
    public static final int WIDTH_100 = 100;
    public static final int HEIGHT_100 = 100;
    
    public static final int WIDTH_300 = 300;
    public static final int HEIGHT_300 = 300;
    
    public static final int WIDTH_500 = 500;
    public static final int HEIGHT_500 = 500;
    /**
     * 图片域名
     */
    public static final String IMG_URL = "http://res.flt.17xs.org";
    
    /**
     * 上传图片路径
     */
    public static final String UPLOAD_PATH = "E:/images";
    
    /**
     * 图片真实路径
     */
   // public static final String realUploadPath = "";
}
