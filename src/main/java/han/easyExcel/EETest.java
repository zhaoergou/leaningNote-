/**
 * @FileName: EETest.java
 * @creator zhaohanyang
 * @date Dec 28, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.easyExcel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;

import han.easyPoi.UserBo;
import han.easyPoi.q;
import org.junit.Test;

/**
 * @ClassName: EETest
 * @Description: 
 * @author zhaohanyang
 * @date Dec 28, 2020
 * @version V1.0
 */
public class EETest {
	


	/**
	 * 发生大多数
	 */
	@Test
	public void eeTest1() {
		 // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
        // {} 代表普通变量 {.} 代表是list的变量
        String templateFileName = "easyExcel"+File.separator + "eeTemp.xlsx";

        String fileName ="easyExcel"+File.separator + "eeout.xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        // 这里注意 入参用了forceNewRow 代表在写入list的时候不管list下面有没有空行 都会创建一行，然后下面的数据往后移动。默认 是false，会直接使用下一行，如果没有则创建。
        // forceNewRow 如果设置了true,有个缺点 就是他会把所有的数据都放到内存了，所以慎用
        // 简单的说 如果你的模板有list,且list不是最后一行，下面还有数据需要填充 就必须设置 forceNewRow=true 但是这个就会把所有数据放到内存 会很耗内存
        // 如果数据量大 list不是最后一行 参照下一个
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        List<EasyExcelDataVO> listData = new ArrayList<EasyExcelDataVO>();
        for (int i = 0; i < 3; i++) {
        	EasyExcelDataVO a = new EasyExcelDataVO();
        	a.setXh(i);
        	a.setBz("test");
        	a.setHdfc(10+i);
        	listData.add(a);
		}
        excelWriter.fill(listData, fillConfig, writeSheet);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", "2019年10月9日13:28:28");
        map.put("zhdld", 1000);
        map.put("zsjld", 1000);
        excelWriter.fill(map, writeSheet);
        excelWriter.finish();
	}
	
	
	/**
	 * 内设处室
	 * @return 
	 */
//	@Test
//	public void eeTest2() {
//		 // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
//        // {} 代表普通变量 {.} 代表是list的变量
//        String templateFileName = "easyExcel"+File.separator + "内设处室模板.xlsx";
//
//        String fileName ="easyExcel"+File.separator + "内设处室导出.xlsx";
//        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName)
//        		.inMemory(Boolean.TRUE).build();
//        WriteSheet writeSheet = EasyExcel
//        		.writerSheet(0)
//        		.build();
//        // 这里注意 入参用了forceNewRow 代表在写入list的时候不管list下面有没有空行 都会创建一行，然后下面的数据往后移动。默认 是false，会直接使用下一行，如果没有则创建。
//        // forceNewRow 如果设置了true,有个缺点 就是他会把所有的数据都放到内存了，所以慎用
//        // 简单的说 如果你的模板有list,且list不是最后一行，下面还有数据需要填充 就必须设置 forceNewRow=true 但是这个就会把所有数据放到内存 会很耗内存
//        // 如果数据量大 list不是最后一行 参照下一个
//        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
//        	List<NscsListData> listData = new ArrayList<NscsListData>();
//        	for (int j = 0; j < 8; j++) {
//        		NscsListData nld = new NscsListData();
//        		nld.setXh(j);
//        		nld.setBz("内设处室");
//        		nld.setGg("10"+j);
//        		nld.setJgmc("机构名称");
//            	listData.add(nld);
//			}
//        System.out.println(listData.toString());
//        try {
//            excelWriter.fill(new FillWrapper("a", listData), fillConfig, writeSheet);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("date", "2019年10月9日13:28:28");
//        map.put("zzz", 1000);
//        excelWriter.fill(map, writeSheet);
//        excelWriter.finish();
//	}
	
	/**
	 * 模板填充   单元格合并(完成
	 */
	@Test
	public void eeTest3() {
		 // 模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替
        // {} 代表普通变量 {.} 代表是list的变量
        String templateFileName = "D://内设处室模板2.xlsx";
        String fileName ="D://内设处室导出2.xlsx";
        ExcelWriterBuilder excelWriterBuilder = EasyExcel.write(new File(fileName))
                .withTemplate(templateFileName);
            excelWriterBuilder.inMemory(Boolean.TRUE);
            ExcelWriter excelWriter = excelWriterBuilder.build();
//        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();

        WriteSheet writeSheet = EasyExcel
        		.writerSheet(0)
        		.registerWriteHandler(CellMergeWriterHandler.getCellWriteHandler(CellMergeWriterHandler.CellMergeEnum.ROW, Arrays.asList(1)))
                .build();
        // 这里注意 入参用了forceNewRow 代表在写入list的时候不管list下面有没有空行 都会创建一行，然后下面的数据往后移动。默认 是false，会直接使用下一行，如果没有则创建。
        // forceNewRow 如果设置了true,有个缺点 就是他会把所有的数据都放到内存了，所以慎用
        // 简单的说 如果你的模板有list,且list不是最后一行，下面还有数据需要填充 就必须设置 forceNewRow=true 但是这个就会把所有数据放到内存 会很耗内存
        // 如果数据量大 list不是最后一行 参照下一个
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
//        q qqq = new q();
//        List<UserBo> listData = qqq.selectUserInfo();
        List<UserBo> list = new ArrayList<UserBo>();
        for (int i = 0; i < 7; i++) {
            UserBo userBo = new UserBo(i + 1, "机构名称" + i / 3, "一正一副", "内设处室", "老大", i, i + 3, "老大", "男", i, i, "备注");
            list.add(userBo);
        }
        try {
            excelWriter.fill(new FillWrapper("a", list), fillConfig, writeSheet);
		} catch (Exception e) {
			e.printStackTrace();
		}
        Map<String, Object> map = new HashMap<String, Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        map.put("zzz", 1000);
        map.put("date", sdf.format(new Date()));
        excelWriter.fill(map, writeSheet);
        excelWriter.finish();
	}
	
}
