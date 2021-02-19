package com.segurosbolivar.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelWriter {

    private static final String[] columns = {
            "ID EJECUCION",
            "FECHA",
            "HORA INICIO",
            "HORA FIN",
            "AREA",
            "SUITE",
            "CASO",
            "ESTADO",
            "PORTAL",
            "AUTOMATIZADOR",
            "PROVEEDOR",
            "TIEMPO EJECUCION",
            "TIEMPO EJECUCION MANUAL",
            "AMBIENTE",
            "TIPO AUTOMATIZACION"
    };

    private String pathFileName;

    public ExcelWriter(String pathFileName) throws IOException {
        this.pathFileName = pathFileName;
        this.createFile();
    }

    private void createFile() throws IOException {

        File excel = new File(this.pathFileName);
        if (!excel.exists()) {

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Executions");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 10);
            headerFont.setColor(IndexedColors.GREY_80_PERCENT.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Create a Row
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }

            FileOutputStream fileOut = new FileOutputStream(this.pathFileName);
            workbook.write(fileOut);
            fileOut.close();
        }
    }

    public void write(TestingExecution testingExecution) {

        FileInputStream executionFile = null;
        try {
            executionFile = new FileInputStream(this.pathFileName);

            Workbook executionFileSheet = new XSSFWorkbook(executionFile);

            this.setDataToNewRow(testingExecution, executionFileSheet);

            executionFile.close();
            FileOutputStream output_file = new FileOutputStream(new File(this.pathFileName));
            //write changes
            executionFileSheet.write(output_file);
            output_file.close();
            System.out.println(" is successfully written");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setDataToNewRow(TestingExecution testingExecution, Workbook executionFileSheet) {
        Sheet worksheet = executionFileSheet.getSheetAt(0);
        int lastRow = worksheet.getLastRowNum();
        Row row = worksheet.createRow(++lastRow);
        row.createCell(0).setCellValue(testingExecution.id);
        row.createCell(1).setCellValue(testingExecution.dateExecution);
        row.createCell(2).setCellValue(testingExecution.startExecution);
        row.createCell(3).setCellValue(testingExecution.endExecution);
        row.createCell(4).setCellValue(testingExecution.area);
        row.createCell(5).setCellValue(testingExecution.suiteName);
        row.createCell(6).setCellValue(testingExecution.caseName);
        row.createCell(7).setCellValue(testingExecution.executionState);
        row.createCell(8).setCellValue(testingExecution.portal);
        row.createCell(9).setCellValue(testingExecution.automatizador);
        row.createCell(10).setCellValue(testingExecution.providerName);
        row.createCell(11).setCellValue(testingExecution.executionTime);
        row.createCell(12).setCellValue(testingExecution.manualExecutionTime);
        row.createCell(13).setCellValue(testingExecution.environment);
        row.createCell(14).setCellValue(testingExecution.automationType);
    }

}
