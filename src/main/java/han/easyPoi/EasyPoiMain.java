/**
 * @FileName: EasyPoiMain.java
 * @creator zhaohanyang
 * @date Dec 23, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.easyPoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import lombok.Cleanup;

/**
 * @ClassName: EasyPoiMain
 * @Description: 
 * @author zhaohanyang
 * @date Dec 23, 2020
 * @version V1.0
 */
public class EasyPoiMain {

	@Test
	public void test11() {
		TemplateExportParams params = new TemplateExportParams(
				"src/main/resources/easyPoiTemp.xlsx");
		Map<String, Object> allData = new HashMap<String, Object>();
		allData.put("ludingji", "在编党员信息");
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		for (int i = 0; i < 3; i++) {
			Map<String, String> maptemp = new HashMap<String, String>();
			maptemp.put("jbgz", "elle");
			maptemp.put("bz", "fanning");
			maptemp.put("xm", String.valueOf(i));
			mapList.add(maptemp);
			System.out.println(mapList.get(i).get("xm"));
		}
		allData.put("maplist", mapList);

        Workbook workbook = ExcelExportUtil.exportExcel(params, allData);
		try {
			@Cleanup FileOutputStream fos = new FileOutputStream("D:/zhySoft/hanTest.xlsx");
	        workbook.write(fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 *  干部测试
	 */
	@Test
	public void ganbuTest() {
		TemplateExportParams params = new TemplateExportParams(
				"src/main/resources/ganbuTestTemplate.xlsx");
		Map<String, Object> allData = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Date now = new Date();
		System.out.println(sdf.format(now));
		allData.put("date", sdf.format(now));
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		for (int i = 0; i < 3; i++) {
			Map<String, String> maptemp = new HashMap<String, String>();
			maptemp.put("id", String.valueOf(i));
			maptemp.put("fc", "正处");
			maptemp.put("hdld", "核定领导");
			maptemp.put("hdzc", String.valueOf(i));
			maptemp.put("hdfc", String.valueOf(i));
			mapList.add(maptemp);
		}
		System.out.println(mapList.toString());
		allData.put("dataList", mapList);

        Workbook workbook = ExcelExportUtil.exportExcel(params, allData);
        System.out.println(null == workbook);
		try {
			@Cleanup FileOutputStream fos = new FileOutputStream("D:/zhySoft/hanGanbu.xlsx");
	        workbook.write(fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
