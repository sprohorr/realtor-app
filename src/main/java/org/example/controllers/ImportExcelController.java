package org.example.controllers;

import org.example.service.ImportExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ImportExcelController {

    @Autowired
    protected ImportExcelService excelService;

    @GetMapping("/export")
    public void exportDataToExcel(@RequestParam("buildingId") int id,
                                  HttpServletResponse response) {
        try {
            excelService.downloadDataToExcel(id, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/import")
    public String importExcel() {
        return "/import";
    }

    @PostMapping("/import")
    public String importDataFromExcel(@RequestParam("file") MultipartFile file) {
        if (!file.getContentType().equals("xlsx")) {
            return "importerror";
        }
        try {
            excelService.uploadDataFromExcel(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/adminpage";
    }

    @GetMapping("/importerror")
    public String error() {
        return "/importerror";
    }
}
