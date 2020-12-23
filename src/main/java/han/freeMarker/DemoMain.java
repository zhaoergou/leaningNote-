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
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import freemarker.template.Configuration;
import freemarker.template.Template;

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
		Writer out = null;
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
		t.process(dataMap, out);
	}
	
	
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoMain dm = new DemoMain();
		try {
			dm.exportFree();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
