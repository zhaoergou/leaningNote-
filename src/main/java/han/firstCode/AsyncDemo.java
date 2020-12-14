/**
 * @FileName: AsyncDemo.java
 * @creator zhaohanyang
 * @date Nov 24, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.firstCode;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
	
	private BigDecimal partyBase;
	public BigDecimal getPartyBase() {
		return partyBase;
	}

	public void setPartyBase(BigDecimal partyBase) {
		this.partyBase = partyBase;
	}
	public void setPartyBase(String partyBase) {
		this.partyBase = new BigDecimal(partyBase);
	}
	public void setPartyBase(Double partyBase) {
		this.partyBase = BigDecimal.valueOf(partyBase);
	}
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
//		AsyncDemo han = new AsyncDemo();
//		han.privateString = "999";
		String sss = "\\";
		String sss2 = "\\\\";
		// TODO Auto-generated method stub
//		BigDecimal bd = new BigDecimal(0.1);
//		BigDecimal bd2 = BigDecimal.valueOf(0.1);
		AsyncDemo asd = new AsyncDemo();
		asd.setPartyBase(0.22);
		System.out.println(asd.getPartyBase());
		asd.setPartyBase("0.332343");
		DecimalFormat df = new DecimalFormat("#####0.00");
		System.out.println(df.format(asd.getPartyBase()));
		asd.setPartyBase(new BigDecimal(0.22));
		System.out.println(asd.getPartyBase());
		System.out.println(asd.getPartyBase().compareTo(new BigDecimal("0.22")));
	}

}
