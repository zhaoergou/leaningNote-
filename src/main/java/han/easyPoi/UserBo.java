/**
 * @FileName: qq.java
 * @creator zhaohanyang
 * @date Dec 28, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.easyPoi;

import org.apache.poi.ss.usermodel.FillPatternType;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.annotation.write.style.HeadStyle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: qq
 * @Description: 
 * @author zhaohanyang
 * @date Dec 28, 2020
 * @version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ContentRowHeight(30)
@HeadRowHeight(30)
@ColumnWidth(17)
//头背景设置成红色 IndexedColors.RED.getIndex()
@HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 9)
public class UserBo {
    @ColumnWidth(8)
    @ExcelProperty("序号")
    private Integer xh;
    private String jgmc;
    @ColumnWidth(8)
    @ExcelProperty("规格")
    private String gg;
    @ColumnWidth(30)
    private String nscs;
    private String hdldzs;
    @ColumnWidth(8)
    private Integer hdzk;
    @ColumnWidth(8)
    @ExcelProperty("副科")
    private Integer hdfk;
    private String sjpbgb;
    private String sjpbzj;
    @ColumnWidth(8)
    @ExcelProperty("副科")
    private Integer sjzk;
    @ColumnWidth(8)
    private Integer sjfk;
    @ColumnWidth(20)
    private String bz;
    
}

