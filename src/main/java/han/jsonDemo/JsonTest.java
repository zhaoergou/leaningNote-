/**
 * @FileName: JsonTest.java
 * @creator zhaohanyang
 * @date Mar 15, 2021
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.jsonDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: JsonTest
 * @Description: 
 * @author zhaohanyang
 * @date Mar 15, 2021
 * @version V1.0
 */
public class JsonTest {

	public static void main(String[] args) {
		String json = "[\"v_hymc\", \"v_hysj\", \"v_hydd\"]";
		JSONArray a =JSONObject.parseArray(json);
		for (Object object : a) {
			System.out.println(object);
		}
	}
}
