/**
 * @FileName: CellMergeWriterHandler.java
 * @creator zhaohanyang
 * @date Dec 29, 2020
 * @editor
 * @Description: 
 * @version V1.0
 */
package han.easyPoi;

import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.merge.AbstractMergeStrategy;

/**
 * @ClassName: CellMergeWriterHandler
 * @Description: 
 * @author zhaohanyang
 * @date Dec 29, 2020
 * @version V1.0
 */
public class CellMergeWriterHandler {

    public static CellWriteHandler getCellWriteHandler(CellMergeEnum cellMergeEnum) {
        if(CellMergeEnum.ROW.equals(cellMergeEnum)) {
            return new RowMergeWriterHandler();
        }

        if(CellMergeEnum.COLUMN.equals(cellMergeEnum)) {
            return new ColumnMergeWriterHandler();
        }

        return null;
    }

    
    public static CellWriteHandler getCellWriteHandler(CellMergeEnum cellMergeEnum, List<Integer> cols) {
        if(CellMergeEnum.ROW.equals(cellMergeEnum)) {
            return new RowMergeWriterHandler(cols);
        }

        if(CellMergeEnum.COLUMN.equals(cellMergeEnum)) {
            return new ColumnMergeWriterHandler(cols);
        }

        return null;
    }

    public static class ColumnMergeWriterHandler extends AbstractMergeStrategy {

        private List<Integer> mergeCols;

        public ColumnMergeWriterHandler() {}

        public ColumnMergeWriterHandler(List<Integer> mergeCols) {
            this.mergeCols = mergeCols;
        }

        @Override
        protected void merge(Sheet sheet, Cell cell, Head head, Integer relativeRowIndex) {
            if(CollectionUtils.isNotEmpty(this.mergeCols) && !this.mergeCols.contains(cell.getColumnIndex())) {
                return;
            }
            mergeCell(sheet, cell, CellMergeEnum.COLUMN);
        }

    }


    public static class RowMergeWriterHandler extends AbstractMergeStrategy {

        private List<Integer> mergeCols;

        public RowMergeWriterHandler() {}

        public RowMergeWriterHandler(List<Integer> mergeCols) {
            this.mergeCols = mergeCols;
        }

        @Override
        protected void merge(Sheet sheet, Cell cell, Head head, Integer relativeRowIndex) {
            if(CollectionUtils.isNotEmpty(mergeCols) && !mergeCols.contains(cell.getColumnIndex())) {
                return;
            }
            mergeCell(sheet, cell, CellMergeEnum.ROW);
        }
    }


    private static void mergeCell(Sheet sheet, Cell cell, CellMergeEnum cellMergeEnum) {
        //单元格为空情况则不做处理
        if (Objects.isNull(cell)) {
            return;
        }

        int rowIndex = cell.getRowIndex(), colIndex = cell.getColumnIndex();

        //获取列的上一行单元格
        Row preRow = null;
        Cell preCell = null;

        if(CellMergeEnum.ROW.equals(cellMergeEnum)) {
            preRow = sheet.getRow(rowIndex - 1);
            preCell = preRow.getCell(colIndex);
        }

        if(CellMergeEnum.COLUMN.equals(cellMergeEnum)) {
            if(colIndex == 0) {
                return;
            }
            preRow = cell.getRow();
            preCell = preRow.getCell(colIndex - 1);
        }

        if (Objects.isNull(preRow)) {
            return;
        }

        Object preCellValue = getCellValue(preCell), curCellValue = getCellValue(cell);
        if (Objects.isNull(preCellValue) || Objects.isNull(curCellValue) || !preCellValue.equals(curCellValue)) {
            return;
        }

        mergeRows(sheet, preCell, cell);
    }


    /**
     * 行单元格合并
     *
     * @param sheet
     * @param preCell
     * @param curCell
     */
    private static void mergeRows(Sheet sheet, Cell preCell, Cell curCell) {
        List<CellRangeAddress> list = sheet.getMergedRegions();
        curCell.setCellType(CellType.BLANK);
        if (CollectionUtils.isEmpty(list)) {
            sheet.addMergedRegion(new CellRangeAddress(preCell.getRowIndex(), curCell.getRowIndex(), preCell.getColumnIndex(), curCell.getColumnIndex()));
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            CellRangeAddress cellRangeAddress = list.get(i);
            if (cellRangeAddress.containsRow(preCell.getRowIndex()) && cellRangeAddress.containsColumn(preCell.getColumnIndex())) {
                int firstRowIndex = cellRangeAddress.getFirstRow(), firstColIndex = cellRangeAddress.getFirstColumn();
                sheet.removeMergedRegion(i);
                sheet.addMergedRegion(new CellRangeAddress(firstRowIndex, curCell.getRowIndex(), firstColIndex, curCell.getColumnIndex()));
                return;
            }
        }
        sheet.addMergedRegion(new CellRangeAddress(preCell.getRowIndex(), curCell.getRowIndex(), preCell.getColumnIndex(), curCell.getColumnIndex()));
    }


    /**
     * 获取单元格的值
     *
     * @param cell
     * @return
     */
    protected static Object getCellValue(Cell cell) {
        if (Objects.isNull(cell)) {
            return null;
        }

        CellType cellTypeEnum = cell.getCellTypeEnum();
        switch (cellTypeEnum) {
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return null;
        }
    }

    public enum CellMergeEnum {
        ROW, COLUMN;
    }
}
