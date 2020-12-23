/**
 * @FileName: package-info.java
 * @creator zhaohanyang
 * @date Dec 14, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
/**
 * @ClassName: package-info
 * @Description: 
 * @author zhaohanyang
 * @date Dec 14, 2020
 * @version V1.0
 */
package han.replace;

import java.math.BigDecimal;

class ReplaceDemo{

	/**
	 *  Stirng.replaceAll  or replaceFirst   参数是正则表达式，    无法识别()括号
	 * @param args
	 */
	public static void main(String[] args) {
//		String url = "http://113.125.201.131:9300/group1/dangjian/2019102214111337/"
//				+ "sccddjcs/sccddjcs_/20201210/16/05/4/1607587498841成都党建蓝湖链接().xls?download=1";
//		String newChar = "1607587498841%E6%88%90%E9%83%BD%E5%85%9A%E5%BB%BA%E8%93%9D%E6%B9%96%E9%93%BE%E6%8E%A5%283%29.xls";
//		url = url.replaceFirst("1607587498841成都党建蓝湖链接()", "22222");
//		System.out.println(url);
//		
//		BigDecimal paid = new BigDecimal("6");
//		BigDecimal pable = new BigDecimal("4");
//		System.out.println(paid.compareTo(pable));
//		BigDecimal paid2 = new BigDecimal("4");
//		BigDecimal pable2 = new BigDecimal("4");
//		System.out.println(paid2.compareTo(pable2));
//		BigDecimal paid3 = new BigDecimal("2");
//		BigDecimal pable3 = new BigDecimal("4");
//		System.out.println(paid3.compareTo(pable3));
		BigDecimal paid4 = new BigDecimal("0.0");
		Double pable4 = new Double(0.00);
		System.out.println(paid4);
		System.out.println(pable4);
		System.out.println(paid4.doubleValue()==pable4);
		
	}
			
}