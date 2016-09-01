/**
 * 
 */
package com.unclechen.sp;

import org.springframework.beans.factory.BeanFactory;

/**
 * @author unclechen 系统常量
 */
public class Constant {
	// spring正面类
	public static Facade FACADE = null;
	public static BeanFactory BF = null;
	// 后台管理列表页显示数量
	public static int PAGESIZE = 20;
	// 多个属性的分隔符
	public static String SEPARATOR = "##";

	// 数据库读状态
	public static String READ = "R";
	// 数据库写状态
	public static String WRITE = "W";

	// 首字母
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
