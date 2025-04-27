package com.sun.yang.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;

@Slf4j
public class ExcelUtils {
    /**
     * 获取HSSFWorkbook操作.xls后缀的excel文件
     * .xls文件一个sheet中最多支持2^16行
     * @param sheetName
     * @param title
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String []title){

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

        //声明列对象
        HSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        return wb;
    }


    /**
     * 获取XSSFWorkbook操作.xlsx后缀的excel文件
     * @param sheetName
     * @param title
     * @return
     */
    public static XSSFWorkbook getXSSFWorkbook(String sheetName, String []title){

        // 第一步，XSSFWorkbook，对应一个Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        XSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

        //声明列对象
        XSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        return wb;
    }

    /**
     * 获取SXSSFWorkbook操作.xlsx后缀的excel文件
     * @param sheetName
     * @param title
     * @return
     */
    public static SXSSFWorkbook getSXSSFWorkbook(String sheetName, String []title){

        // 第一步，XSSFWorkbook，对应一个Excel文件
        SXSSFWorkbook wb = new SXSSFWorkbook(1000);

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        SXSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        SXSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

        //声明列对象
        SXSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        return wb;
    }

    /**
     * 同一个excel 多个 sheet
     * @param wb
     * @param sheetName
     * @param title
     * @return
     */
    public static XSSFWorkbook createXSSFWorkbookSheet(XSSFWorkbook wb, String sheetName, String []title){
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet(sheetName);
        sheet.setDefaultColumnWidth(40);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        XSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        XSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

        //声明列对象
        XSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        return wb;
    }

    /**
     * 同一个excel 多个 sheet
     * @param wb
     * @param sheetName
     * @param title
     * @return
     */
    public static SXSSFWorkbook createSXSSFWorkbookSheet(SXSSFWorkbook wb, String sheetName, String []title){
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        SXSSFSheet sheet = wb.createSheet(sheetName);
        sheet.setDefaultColumnWidth(40);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        SXSSFRow row = sheet.createRow(0);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式

        //声明列对象
        SXSSFCell cell = null;

        //创建标题
        for(int i=0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        return wb;
    }

    /**
     * 输出Workbook
     * @param wb
     * @param filePath
     * @param wbClose
     */
    public static String writeWorkbook(Workbook wb, String filePath, boolean wbClose){
        File outputFile = new File(filePath);
        if (!outputFile.getParentFile().exists()){
            outputFile.getParentFile().mkdir();
        }
        try {
            wb.write(new FileOutputStream(outputFile));
        } catch (FileNotFoundException e){
            String excelPostfix = filePath.substring(filePath.lastIndexOf("."));
            filePath = filePath.replace(excelPostfix, System.currentTimeMillis()+excelPostfix);
            try {
                wb.write(new FileOutputStream(filePath));
                log.warn("[{}]另一个程序正在使用此文件，进程无法访问。", filePath);
                log.warn("重新输出文件为[{}]", filePath);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (wbClose){
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return filePath;
    }


    /**
     * 初始化 cell 内容长度
     * cell 原本内容长度限制 32767  现修改为Integer.MAX_VALUE
     */
    public static void initCellMaxTextLength() {
        SpreadsheetVersion excel2007 = SpreadsheetVersion.EXCEL2007;
        if (Integer.MAX_VALUE != excel2007.getMaxTextLength()) {
            Field field;
            try {
                field = excel2007.getClass().getDeclaredField("_maxTextLength");
                field.setAccessible(true);
                field.set(excel2007,Integer.MAX_VALUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
