package com.zhangxu.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

	/**
	 * 解析文件
	 * @param filePath  文件路径
	 * @param splitstring	切割 符号
	 * @return
	 */
	public static List<Object[]> readFile(String filePath,String splitstring) {
		try {
			File file  = new File(filePath);
			//按行读取
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			
			List<Object[]> list = new ArrayList<Object[]>();
			while((str = br.readLine())!= null){
				String[] split = str.split(splitstring);
				list.add(split);
			}
			br.close();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 获取文件扩展名
	 * @param file
	 * @return
	 */
	public static String getFileName(File file){
		String substring = null;
		if(file.exists()){
			substring = file.getName().substring(file.getName().indexOf(".")+1);
		}
		return substring;
	}
	
	/**
	 * 删除文件，如果是目录，则下面的文件和所有子目录中的文件都要删除
	 * @param file
	 */
	public static void delFile(File file) {
        File[] files = file.listFiles();
        if (files != null && files.length != 0) {
            for (int i = 0;i<files.length;i++) {
                delFile(files[i]);
            }
        }
        file.delete();
    }
}
