package com.example.demo.libros;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    public byte[] generateExcel(List<libros> librosList) throws IOException {
        // Crear un nuevo libro de Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Libros");

        // Crear la fila de encabezados
        Row headerRow = sheet.createRow(0);
        String[] columns = {"ID", "Nombre", "Categoría", "Precio", "Autor", "Género"};
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // Llenar el archivo con los datos de los libros
        int rowNum = 1;
        for (libros libro : librosList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(libro.getId());
            row.createCell(1).setCellValue(libro.getName());
            row.createCell(2).setCellValue(libro.getCategoria());
            row.createCell(3).setCellValue(libro.getPrecio());
            row.createCell(4).setCellValue(libro.getAutor());
            row.createCell(5).setCellValue(libro.getGenero());
        }

        // Ajustar el tamaño de las columnas al contenido
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Convertir el libro de Excel a un array de bytes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
}