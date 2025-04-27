package com.sun.yang.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class ExcelTest {
    /**
     * 表头
     */
    private static String[] titles = {"模式名"};
    private static String[] schemas = {"auth_0",
            "auth_1",
            "auth_2",
            "auth_3",
            "auth_4",
            "auth_5",
            "auth_6",
            "auth_7"
          };
    public static void main(String[] args) {
        SXSSFWorkbook wb = ExcelUtils.getSXSSFWorkbook("sheet1", titles);
        SXSSFSheet sheet = wb.getSheetAt(0);
        int rowNum = 1;
        SXSSFRow row = null;
        SXSSFCell cell = null;
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setColor(Font.COLOR_RED);
        style.setFont(font);
        for(String schema:schemas){
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(schema);
        }
        ExcelUtils.writeWorkbook(wb, "E:\\sql\\excel\\text.xlsx", true);
    }
}
