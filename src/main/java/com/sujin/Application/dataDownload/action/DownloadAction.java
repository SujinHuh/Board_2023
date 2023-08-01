package com.sujin.Application.dataDownload.action;

import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.OutputStream;

@Slf4j
@Controller
public class DownloadAction {

    /***
     *
     get -> return string (page 이동)
     post -> return response (api 호출)
     */

    @GetMapping("/download/excel")
    public String excelDownload(){
        log.info("excel download");
        return "/download/excel";
    }

    @PostMapping("/download/excel")
    public void excelDownload(HttpServletResponse response) throws IOException {
        Workbook wb = new XSSFWorkbook();
        log.info("Post excel download");
        //Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("첫번째 시트");
        Row row;
        Cell cell;
        int rowNum = 0;

        // Header
        row = sheet.createRow(rowNum++);
        cell = (Cell) row.createCell(0);
        cell.setCellValue("번호");
        cell = (Cell) row.createCell(1);
        cell.setCellValue("이름");
        cell = row.createCell(2);
        cell.setCellValue("제목");

        // Body
        for (int i = 0; i < 3; i++) {
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellValue(i);
            cell = row.createCell(1);
            cell.setCellValue(i + "_name");
            cell = row.createCell(2);
            cell.setCellValue(i + "_title");
        }

        // 컨텐츠 타입과 파일명 지정
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment; filename=example.xlsx");

        // Excel File Output
        try (OutputStream outputStream = response.getOutputStream()) {
            wb.write(outputStream);
        }
        wb.close();
    }

}
