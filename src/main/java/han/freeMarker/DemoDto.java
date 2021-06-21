/**
 * @FileName: DemoDto.java
 * @creator zhaohanyang
 * @date Dec 22, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.freeMarker;

import lombok.Data;

/**
 * @ClassName: DemoDto
 * @Description: 
 * @author zhaohanyang
 * @date Dec 22, 2020
 * @version V1.0
 */
public class DemoDto {

	private String biaoti = "freeMarker測試主体";
	private String beizhu = "freeMarker測試备注";
	public String getBiaoti() {
		return biaoti;
	}
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	
}
