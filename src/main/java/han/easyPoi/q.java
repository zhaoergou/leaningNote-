/**
 * @FileName: q.java
 * @creator zhaohanyang
 * @date Dec 28, 2020
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.Test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;

/**
 * @ClassName: q
 * @Description: 
 * @author zhaohanyang
 * @date Dec 28, 2020
 * @version V1.0
 */
public class q {

	/**
	 * 模板填充   单元格合并
	 */
	@Test
	public void testExport2() {
//        设置第几列合并
		int[] mergeColumnIndex = { 1 };
//        需要从第几行开始合并
		int mergeRowIndex = 3;
		List<UserBo> resultList = selectUserInfo();
		// 使用java8新特性的stream流去处理数据，把空的数据过滤掉
		List<UserBo> resultBo = resultList.stream().filter(Objects::nonNull).map(t -> {
			return UserBo.builder().xh(t.getXh()).jgmc(t.getJgmc()).gg(t.getGg()).nscs(t.getNscs())
					.hdldzs(t.getHdldzs()).hdzk(t.getHdzk()).hdfk(t.getHdfk()).sjpbgb(t.getSjpbgb())
					.sjpbzj(t.getSjpbzj()).sjzk(t.getSjzk()).sjfk(t.getSjfk()).bz(t.getBz()).build();
		}).collect(Collectors.toList());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("easyExcel"+File.separator+"aa内设处室导出.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EasyExcel.write(fos, UserBo.class)
//                    excel版本
				.excelType(ExcelTypeEnum.XLSX)
//                    是否自动关流
				.autoCloseStream(Boolean.TRUE)
				//.registerWriteHandler(CellMergeWriterHandler.getCellWriteHandler(CellMergeWriterHandler.CellMergeEnum.COLUMN, Arrays.asList(1)))
		        .registerWriteHandler(CellMergeWriterHandler.getCellWriteHandler(CellMergeWriterHandler.CellMergeEnum.ROW, Arrays.asList(15)))
				.head(head())
				.sheet("内设处室")
				.doWrite(resultBo);
	}

	@Test
	public void testExport1() {
		try {
//	            设置第几列合并
			int[] mergeColumnIndex = { 1 };
//	            需要从第几行开始合并
			int mergeRowIndex = 3;
			// response.setContentType("application/vnd.ms-excel");
			// response.setCharacterEncoding("utf-8");
			// 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
			List<UserBo> resultList = selectUserInfo();
			// 使用java8新特性的stream流去处理数据，把空的数据过滤掉
			List<UserBo> resultBo = resultList.stream().filter(Objects::nonNull).map(t -> {
				return UserBo.builder().xh(t.getXh()).jgmc(t.getJgmc()).gg(t.getGg()).nscs(t.getNscs())
						.hdldzs(t.getHdldzs()).hdzk(t.getHdzk()).hdfk(t.getHdfk()).sjpbgb(t.getSjpbgb())
						.sjpbzj(t.getSjpbzj()).sjzk(t.getSjzk()).sjfk(t.getSjfk()).bz(t.getBz()).build();
			}).collect(Collectors.toList());
			// 设置文件名称
			// response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
			// sheet名称
			FileOutputStream fos = new FileOutputStream("D:\\zhySoft\\leaningNote\\easyExcel\\123.xlsx");
			EasyExcel.write(fos, UserBo.class)
//	                    excel版本
					.excelType(ExcelTypeEnum.XLSX)
//	                    是否自动关流
					.autoCloseStream(Boolean.TRUE)
					.registerWriteHandler(new ExcelFillCellMergeStrategy(mergeRowIndex, mergeColumnIndex))
					.head(head())
					.sheet("内设处室")
					.doWrite(resultBo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<List<String>> head() {
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> head0 = new ArrayList<String>();
		// 序号 机构名称 规格 内设处室 核定领导职数 正科 副科 实际配备干部 实际配备 职数 正科 副科 备注

		head0.add("高新区机关内设处室领导职数及实际配备情况表");
		head0.add(" ");
		head0.add("序号");
		List<String> head1 = new ArrayList<String>();
		head1.add("高新区机关内设处室领导职数及实际配备情况表");
		head1.add(" ");
		head1.add("机构名称");
		List<String> head2 = new ArrayList<String>();
		head2.add("高新区机关内设处室领导职数及实际配备情况表");
		head2.add(" ");
		head2.add("规格");
		List<String> head3 = new ArrayList<String>();
		head3.add("高新区机关内设处室领导职数及实际配备情况表");
		head3.add(" ");
		head3.add("内设处室");
		List<String> head4 = new ArrayList<String>();
		head4.add("高新区机关内设处室领导职数及实际配备情况表");
		head4.add(" ");
		head4.add("核定领导职数");
		List<String> head5 = new ArrayList<String>();
		head5.add("高新区机关内设处室领导职数及实际配备情况表");
		head5.add(" ");
		head5.add("正科");
		List<String> head6 = new ArrayList<String>();
		head6.add("高新区机关内设处室领导职数及实际配备情况表");
		head6.add(" ");
		head6.add("副科");
		List<String> head7 = new ArrayList<String>();
		head7.add("高新区机关内设处室领导职数及实际配备情况表");
		head7.add(" ");
		head7.add("实际配备干部	");
		List<String> head8 = new ArrayList<String>();
		head8.add("高新区机关内设处室领导职数及实际配备情况表");
		head8.add(" ");
		head8.add("实际配备职数");
		List<String> head9 = new ArrayList<String>();
		head9.add("高新区机关内设处室领导职数及实际配备情况表");
		head9.add(" ");
		head9.add("正科");
		List<String> head10 = new ArrayList<String>();
		head10.add("高新区机关内设处室领导职数及实际配备情况表");
		head10.add(" ");
		head10.add("副科");
		List<String> head11 = new ArrayList<String>();
		head11.add("高新区机关内设处室领导职数及实际配备情况表");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

		head11.add(sdf.format(new Date()));
		head11.add("备注");

		list.add(head0);
		list.add(head1);
		list.add(head2);
		list.add(head3);
		list.add(head4);
		list.add(head5);
		list.add(head6);
		list.add(head7);
		list.add(head8);
		list.add(head9);
		list.add(head10);
		list.add(head11);
		return list;
	}

	public List<UserBo> selectUserInfo() {

		List<UserBo> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			UserBo userBo = new UserBo(i + 1, "机构名称" + i / 3, "一正一副", "内设处室", "老大", i, i + 3, "老大", "男", i, i, "备注");
			list.add(userBo);
		}
		return list;
	}

}
