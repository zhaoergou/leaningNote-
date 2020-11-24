/**
 * @FileName: AsyncDemo.java
 * @creator zhaohanyang
 * @date Nov 24, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.firstCode;

/**
 * @ClassName: AsyncDemo
 * @Description: 
 * @author zhaohanyang
 * @date Nov 24, 2020
 * @version V1.0
 */
public class AsyncDemo {

	@SuppressWarnings("unused")
	private static String outString = "asyncBegin";
	public String privateString = "222";
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		AsyncDemo han = new AsyncDemo();
		han.privateString = "999";
		
		// TODO Auto-generated method stub
		System.out.println(han.privateString);
	}

}
