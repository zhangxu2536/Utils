package com.zhangxu.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 以后字符串相关的处理可以来找它
 * @author wanghd
 */
public class StringUtil {

	/**
	 *  判断源字符串是否有值，空引号和空格也算没值
	 * @param str
	 * @return  如果为空返回true 否则   false
	 */
	public static boolean isEmpty(String str){
		return str==null || str.trim().length() <=0;
	}
	/**
	 * 判断是否为手机号码
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		//用正则表达式来校验
		String reg = "1[3|5|6|7|8]\\d{9}";
		return str.matches(reg);
	}
	/**
	 * 判断是否为电子邮箱
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		//用正则表达式来校验
		String reg = "\\w+@\\w+(.com|.cn|.com.cn)";
		return str.matches(reg);
	}
	/**
	 * 判断是否全部为字母 
	 * @param str
	 * @return
	 */
	public static boolean isString(String str){
		String reg = "[a-zA-Z]+";
		return str.matches(reg);
	}
	

	/**
	 * 获取n位随机英文字符串
	 * @param num
	 * @return
	 */
	public static String getRandomString(int length){
		//随机
		Random rm =new Random();
		char[] c = {'a','b','c','d','e','f','g','h','y',
				'j','k','l','m','n','r','t','o','i','p','s','q','u','v','w','x','y','z'};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			//获取随机数  0 - 25
			int nextInt = rm.nextInt(26);
			//通过下标获取字符，将字符自传成字符串
			String str = c[nextInt]+"";
			int nextInt2 = rm.nextInt();
			//如果随机生成的数能被2整除   转成大写
			if(nextInt2 %2 ==0){
				//toUpperCase()  将字符串转换成大写
				str = str.toUpperCase();
			}
			//追加
			sb.append(str);
		}
		return sb.toString();
	}
	
	
	/**
	 * 获取n位随机英文和数字字符串
	 * @param length
	 * @return
	 */
	public static String getRandomStringAndNumber(int length){
		//随机
		Random rm =new Random();
		char[] c = {'a','b','c','d','e','f','g','h','y',
				'j','k','l','m','n','r','t','o','i','p','s',
				'q','u','v','w','x','y','z','0','1','2','3','4',
				'5','6','7','8','9'};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			//获取随机数  0 - 25
			int nextInt = rm.nextInt(36);
			//通过下标获取字符，将字符自传成字符串
			String str = c[nextInt]+"";
			int nextInt2 = rm.nextInt();
			//如果随机生成的数能被2整除   转成大写
			if(nextInt2 %2 ==0){
				//toUpperCase()  将字符串转换成大写
				str = str.toUpperCase();
			}
			//追加
			sb.append(str);
		}
		return sb.toString();
	}
	
	
	/**
	 * 获取n位随机英文和数字字符串
	 * @param length
	 * @return
	 */
	public static String getRandomStringAndNumber2(int length){
		//随机
		Random rm =new Random();
		StringBuffer sb = new StringBuffer();
		/*
		for (int i = 0; i < length; i++) {
			
			48-57 0-9
			65-90 A-Z
			97-122 a-z
			
		}*/
		for (int i = 0; i < length; i++) {
			int nextInt = rm.nextInt(123);
			if((nextInt>=48 && nextInt <=57) || (nextInt>=65 && nextInt <=90) || (nextInt>=97 && nextInt <=122) ){
				String str = (char)nextInt+"";
				sb.append(str);
			}else{
				i--;
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 获取n个随机中文字符串
	 * @param num
	 * @return
	 */
	public static String getChinese(int length){
		StringBuilder str = new StringBuilder();
        int hs = 0 ;
        int ls = 0; 
        Random random = new Random();
        for(int i = 0 ; i < length ; i++){
	        hs = (176 + Math.abs(random.nextInt(39))); 
	        ls = (161 + Math.abs(random.nextInt(93)));
	        byte[] b = new byte[2];
	        b[0] = (new Integer(hs).byteValue());
	        b[1] = (new Integer(ls).byteValue());
	        try {
	          str.append(new String(b, "GBk")); 
	        } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	        }
        }
        return str.toString();
	}
	
	
	/**
	 * 判断是否是纯数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		String reg = "\\d+";
		return str.matches(reg);
	}
	
	/**
	 * 判断是否是小数
	 * @param str
	 * @return
	 */
	public static boolean isFloat(String str){
		
		if (!isEmpty(str)) {
			//编译正则表达式
			String regex = "^\\d+\\.\\d+$";
			Pattern p = Pattern.compile(regex );
			//调用匹配器
			Matcher matcher = p.matcher(str);
			if (matcher.matches()) {
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isEmpty("   "));
		System.out.println(isPhone("13717796946"));
		System.out.println(isEmail("9128152551@qq.com"));
		System.out.println(isString("com"));
		System.out.println(getRandomString(10));
		System.out.println(getRandomStringAndNumber(10));
		System.out.println(getRandomStringAndNumber2(10));
		System.out.println(getChinese(10));
		System.out.println(isFloat("1.0"));
		System.out.println(isNumber("1"));
	}
	
}
