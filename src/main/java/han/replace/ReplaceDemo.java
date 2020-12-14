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

class ReplaceDemo{

	/**
	 *  Stirng.replaceAll  or replaceFirst   参数是正则表达式，    无法识别()括号
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://113.125.201.131:9300/group1/dangjian/2019102214111337/"
				+ "sccddjcs/sccddjcs_/20201210/16/05/4/1607587498841成都党建蓝湖链接().xls?download=1";
		String newChar = "1607587498841%E6%88%90%E9%83%BD%E5%85%9A%E5%BB%BA%E8%93%9D%E6%B9%96%E9%93%BE%E6%8E%A5%283%29.xls";
		url = url.replaceFirst("1607587498841成都党建蓝湖链接()", "22222");
		System.out.println(url);
	}
			
}