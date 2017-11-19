package com.vote.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageUtil {
	
	/**
	 * 是否为允许图片类型
	 * 
	 * @param fileName
	 * @return
	 */
	public static boolean isImageAllowType(String fileName) {
		String typeName = "";
		// 扩展名格式：
		if (fileName.lastIndexOf(".") >= 0) {
			typeName = fileName.substring(fileName.lastIndexOf("."));
		}
		// 定义允许上传的文件类型
		List<String> fileTypes = new ArrayList<String>();
		fileTypes.add(".jpg");
		fileTypes.add(".jpeg");
		fileTypes.add(".png");
		fileTypes.add(".bmp");
		return fileTypes.contains(typeName.toLowerCase());
	}

	/**
     * 删除图片文件
     * 
     * @param path
     */
    public static boolean deletePicture(String path)
    {
        try
        {
            File file = new File(path);
            if (file.exists())
            {
                file.delete();
                return true;
            }
            return false;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
