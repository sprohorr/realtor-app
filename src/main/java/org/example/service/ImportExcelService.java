package org.example.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.entity.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class ImportExcelService {

    @Autowired
    protected ApartmentService apartmentService;

    @Autowired
    protected BuildingService buildingService;

    @Autowired
    protected RealtyAgentService realtyAgentService;

    public void downloadDataToExcel(int id, HttpServletResponse response) throws IOException {
        List<Apartment> apartmentList = apartmentService.findAllApartmentByBuilding(id);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Number");
        headerRow.createCell(1).setCellValue("Quantity rooms");
        headerRow.createCell(2).setCellValue("Area");
        headerRow.createCell(3).setCellValue("Price");
        headerRow.createCell(4).setCellValue("Status");
        headerRow.createCell(5).setCellValue("Description");
        headerRow.createCell(6).setCellValue("Address");
        headerRow.createCell(7).setCellValue("Realty agent");

        for (Apartment apartment : apartmentList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(apartment.getNumber());
            row.createCell(1).setCellValue(apartment.getQuantityRooms());
            row.createCell(2).setCellValue(apartment.getArea());
            row.createCell(3).setCellValue(apartment.getPrice());
            row.createCell(4).setCellValue(apartment.isStatus());
            row.createCell(5).setCellValue(apartment.getDescription());
            row.createCell(6).setCellValue(apartment.getBuilding().getAddress());
            row.createCell(7).setCellValue(apartment.getRealtyAgent().getName());
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=realtorAppApartments.xlsx");

        workbook.write(response.getOutputStream());
    }

    public void uploadDataFromExcel(MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }

            Apartment apartment = new Apartment();
            apartment.setNumber((int) row.getCell(0).getNumericCellValue());
            apartment.setQuantityRooms((int) row.getCell(1).getNumericCellValue());
            apartment.setArea(row.getCell(2).getNumericCellValue());
            apartment.setPrice(row.getCell(3).getNumericCellValue());
            apartment.setStatus(row.getCell(4).getBooleanCellValue());
            apartment.setDescription(row.getCell(5).getStringCellValue());
            apartment.setBuilding(buildingService.findBuildingByAddress(row.getCell(6).getStringCellValue()));
            apartment.setRealtyAgent(realtyAgentService.findRealtyAgentByName(row.getCell(7).getStringCellValue()));

            apartmentService.saveApartmentFromExcel(apartment);
        }
    }
}

