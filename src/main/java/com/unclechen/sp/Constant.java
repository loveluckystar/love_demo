/**
 * 
 */
package com.unclechen.sp;

import org.springframework.beans.factory.BeanFactory;

/**
 * @author unclechen ϵͳ����
 */
public class Constant {
	// spring������
	public static Facade FACADE = null;
	public static BeanFactory BF = null;
	// ��̨�����б�ҳ��ʾ����
	public static int PAGESIZE = 20;
	// ������Եķָ���
	public static String SEPARATOR = "##";

	// ���ݿ��״̬
	public static String READ = "R";
	// ���ݿ�д״̬
	public static String WRITE = "W";

	// ����ĸ
	public static String[] abc = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z" };

	static {
		if (BF == null) {
			BF = ApplicationContextInit.getApplicationContext();
		}
		FACADE = (Facade) BF.getBean("facade");
	}

}
