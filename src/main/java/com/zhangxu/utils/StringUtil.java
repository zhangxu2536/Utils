package com.zhangxu.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ַ���������
 * �Ժ��ַ�����صĴ������������
 * @author wanghd
 */
public class StringUtil {

	/**
	 *  �ж�Դ�ַ����Ƿ���ֵ�������źͿո�Ҳ��ûֵ
	 * @param str
	 * @return  ���Ϊ�շ���true ����   false
	 */
	public static boolean isEmpty(String str){
		return str==null || str.trim().length() <=0;
	}
	/**
	 * �ж��Ƿ�Ϊ�ֻ�����
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str){
		//��������ʽ��У��
		String reg = "1[3|5|6|7|8]\\d{9}";
		return str.matches(reg);
	}
	/**
	 * �ж��Ƿ�Ϊ��������
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str){
		//��������ʽ��У��
		String reg = "\\w+@\\w+(.com|.cn|.com.cn)";
		return str.matches(reg);
	}
	/**
	 * �ж��Ƿ�ȫ��Ϊ��ĸ 
	 * @param str
	 * @return
	 */
	public static boolean isString(String str){
		String reg = "[a-zA-Z]+";
		return str.matches(reg);
	}
	

	/**
	 * ��ȡnλ���Ӣ���ַ���
	 * @param num
	 * @return
	 */
	public static String getRandomString(int length){
		//���
		Random rm =new Random();
		char[] c = {'a','b','c','d','e','f','g','h','y',
				'j','k','l','m','n','r','t','o','i','p','s','q','u','v','w','x','y','z'};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			//��ȡ�����  0 - 25
			int nextInt = rm.nextInt(26);
			//ͨ���±��ȡ�ַ������ַ��Դ����ַ���
			String str = c[nextInt]+"";
			int nextInt2 = rm.nextInt();
			//���������ɵ����ܱ�2����   ת�ɴ�д
			if(nextInt2 %2 ==0){
				//toUpperCase()  ���ַ���ת���ɴ�д
				str = str.toUpperCase();
			}
			//׷��
			sb.append(str);
		}
		return sb.toString();
	}
	
	
	/**
	 * ��ȡnλ���Ӣ�ĺ������ַ���
	 * @param length
	 * @return
	 */
	public static String getRandomStringAndNumber(int length){
		//���
		Random rm =new Random();
		char[] c = {'a','b','c','d','e','f','g','h','y',
				'j','k','l','m','n','r','t','o','i','p','s',
				'q','u','v','w','x','y','z','0','1','2','3','4',
				'5','6','7','8','9'};
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			//��ȡ�����  0 - 25
			int nextInt = rm.nextInt(36);
			//ͨ���±��ȡ�ַ������ַ��Դ����ַ���
			String str = c[nextInt]+"";
			int nextInt2 = rm.nextInt();
			//���������ɵ����ܱ�2����   ת�ɴ�д
			if(nextInt2 %2 ==0){
				//toUpperCase()  ���ַ���ת���ɴ�д
				str = str.toUpperCase();
			}
			//׷��
			sb.append(str);
		}
		return sb.toString();
	}
	
	
	/**
	 * ��ȡnλ���Ӣ�ĺ������ַ���
	 * @param length
	 * @return
	 */
	public static String getRandomStringAndNumber2(int length){
		//���
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
	 * ��ȡn����������ַ���
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
	 * �ж��Ƿ��Ǵ�����
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		String reg = "\\d+";
		return str.matches(reg);
	}
	
	/**
	 * �ж��Ƿ���С��
	 * @param str
	 * @return
	 */
	public static boolean isFloat(String str){
		
		if (!isEmpty(str)) {
			//����������ʽ
			String regex = "^\\d+\\.\\d+$";
			Pattern p = Pattern.compile(regex );
			//����ƥ����
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
