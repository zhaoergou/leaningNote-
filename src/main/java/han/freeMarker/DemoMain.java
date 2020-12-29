/**
 * @FileName: DemoMain.java
 * @creator zhaohanyang
 * @date Dec 22, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.freeMarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.Cleanup;

/**
 * @ClassName: DemoMain
 * @Description: 
 * @author zhaohanyang
 * @date Dec 22, 2020
 * @version V1.0
 */
public class DemoMain {

	private Configuration freeConfiguration = null;
	private void exportFree() throws Exception{
		DemoDto dd = new DemoDto();
		Map dataMap = new HashMap<String, String>();
		dataMap = JSONObject.parseObject(JSONObject.toJSONString(dd), Map.class);
		System.out.println(dataMap.toString());
		freeConfiguration = new Configuration();
		//相对路径在项目leaningNote文件夹里
		freeConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/"));
		freeConfiguration.setDefaultEncoding("utf-8");
		
		Template t = freeConfiguration.getTemplate("freemarkerDemo.ftl");
		t.setEncoding("utf-8");
		
		File outFile = new File("src/main/resources/aahan.xls");
		//lombok注解自动关闭输入输出流
		@Cleanup Writer out = null;
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
		t.process(dataMap, out);
	}

	@Test
	public void exportFree2() {
		Configuration freeConfiguration = null;
		HashMap<String, Object> allMap = new HashMap<String, Object>();
		List<Map<String, String>> dfxxs = new ArrayList<Map<String, String>>();
		allMap.put("ludingji", "下里");
		for (int i = 0; i < 3; i++) {
			DfxxDto dd = new DfxxDto();
			dd.setBz(i);
			Map dataMap = new HashMap<String, String>();
			dataMap = JSONObject.parseObject(JSONObject.toJSONString(dd), Map.class);
			dfxxs.add(dataMap);
		}
		allMap.put("dfxxs", dfxxs);
		System.out.println(allMap.toString());
		freeConfiguration = new Configuration();
		// 相对路径在项目leaningNote文件夹里
		try {
			freeConfiguration.setDirectoryForTemplateLoading(new File("src/main/resources/"));
			freeConfiguration.setDefaultEncoding("utf-8");

			Template t = freeConfiguration.getTemplate("freemarkerTemp2.ftl");
			t.setEncoding("utf-8");

			File outFile = new File("src/main/resources/hanDfxx.xls");
			// lombok注解自动关闭输入输出流
			@Cleanup
			Writer out = null;
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
			t.process(allMap, out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String tryTest() throws Exception {
		try {
			int a = 3/0;
		} catch (Exception e) {
			
		}
		return "222222222";
	}
	
	@Test
	public void trymain() {
		String a = null;
		try {
			a = tryTest();
			System.out.println(a);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(a+"  catch!!  "+e);
		}
	}
//	/**
//	 *
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		DemoMain dm = new DemoMain();
//		try {
//			dm.exportFree();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
