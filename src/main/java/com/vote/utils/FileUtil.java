package com.vote.utils;

import java.io.File;

public class FileUtil {

	
	
	/**
	 * 创建文件夹
	 * @param path
	 * @return
	 */
	 public static boolean mkDirectory(String path) {  
        File file = null;  
        try {  
            file = new File(path);  
            if (!file.exists()) {  
                return file.mkdirs();  
            }  
            else{  
                return false;  
            }  
        } catch (Exception e) {  
        } finally {  
            file = null;  
        }  
        return false;  
    }  
}
