package com.segurosbolivar.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelWriter {

    private static final String[] columns = {
            "ID EJECUCION CASO",
            "ID EJECUCION",
            "FECHA",
            "HORA INICIO",
            "HORA FIN",
            "AREA",
            "SUITE",
            "CASO",
            "ESTADO",
            "PORTAL",
            "EJECUTOR",
            "PROVEEDOR",
            "TIEMPO EJECUCION",
            "TIEMPO EJECUCION MANUAL",
            "AMBIENTE",
            "TIPO AUTOMATIZACION",
            "JIRA ISSUE"
    };

    private final String pathFileName;

    public ExcelWriter(String pathFileName) {
        this.pathFileName = pathFileName;
        this.createFile();
    }

    private void createFile() {

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

            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream(this.pathFileName);
                workbook.write(fileOut);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    fileOut.close();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void write(TestingExecution testingExecution) {

        FileInputStream executionFile = null;
        FileOutputStream output_file = null;
        try {
            executionFile = new FileInputStream(this.pathFileName);

            Workbook executionFileSheet = new XSSFWorkbook(executionFile);

            this.setDataToNewRow(testingExecution, executionFileSheet);
            output_file = new FileOutputStream(new File(this.pathFileName));
            //write changes
            executionFileSheet.write(output_file);
            System.out.println(" is successfully written");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                output_file.close();
                executionFile.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setDataToNewRow(TestingExecution testingExecution, Workbook executionFileSheet) {
        Sheet worksheet = executionFileSheet.getSheetAt(0);
        int lastRow = worksheet.getLastRowNum();
        Row row = worksheet.createRow(++lastRow);
        row.createCell(0).setCellValue(testingExecution.idCaseExecution);
        row.createCell(1).setCellValue(testingExecution.idExecution);
        row.createCell(2).setCellValue(testingExecution.dateExecution);
        row.createCell(3).setCellValue(testingExecution.startExecution);
        row.createCell(4).setCellValue(testingExecution.endExecution);
        row.createCell(5).setCellValue(testingExecution.area);
        row.createCell(6).setCellValue(testingExecution.suiteName);
        row.createCell(7).setCellValue(testingExecution.caseName);
        row.createCell(8).setCellValue(testingExecution.executionState);
        row.createCell(9).setCellValue(testingExecution.portal);
        row.createCell(10).setCellValue(testingExecution.executor);
        row.createCell(11).setCellValue(testingExecution.providerName);
        row.createCell(12).setCellValue(testingExecution.executionTime);
        row.createCell(13).setCellValue(testingExecution.manualExecutionTime);
        row.createCell(14).setCellValue(testingExecution.environment);
        row.createCell(15).setCellValue(testingExecution.automationType);
        row.createCell(16).setCellValue(testingExecution.jiraIssue);
    }

}
