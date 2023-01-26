package com.product.insidetrack.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.product.insidetrack.model.Product;  

public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Purchase Date", "Invoice", "Customer Root", "Customer Leaf","Product Description"
  ,"Pack Size","Unit Type","Category","Distributor Root","Distributor Leaf","Manufacturer","Quantity","Price","Total"};
  static String SHEET = "Sheet1";
  												  	  

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static ByteArrayInputStream productsToExcel(List<Product> Products) {

    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
      Sheet sheet = workbook.createSheet(SHEET);

      // Header
      Row headerRow = sheet.createRow(0);

      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
      }

      int rowIdx = 1;
      for (Product Product : Products) {
        Row row = sheet.createRow(rowIdx++);

        // row.createCell(0).setCellValue(Product.getId());
        // row.createCell(1).setCellValue(Product.getTitle());
        // row.createCell(2).setCellValue(Product.getDescription());
        // row.createCell(3).setCellValue(Product.isPublished());
      }

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }

  public static List<Product> excelToProducts(InputStream is) {
    try {
      Workbook workbook = new XSSFWorkbook(is);

      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      List<Product> Products = new ArrayList<Product>();

      int rowNumber = 0;
      while (rows.hasNext()== true) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        Product product = new Product();

        int cellIdx = 0;
        while (cellsInRow.hasNext()==true) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {
          case 0:
            product.setPurchaseDate( String.valueOf(currentCell.getNumericCellValue()) );
            break;

          case 1:
             product.setInvoice(String.valueOf(currentCell.getNumericCellValue()));
            break;

          case 2:
            product.setCustomerRoot(currentCell.getStringCellValue());
            break;

          case 3:
            product.setCustomerLeaf(currentCell.getStringCellValue());
            break;
          case 4:
            product.setProductDescription(currentCell.getStringCellValue());
            break;
          case 5:
            product.setPackSize(currentCell.getStringCellValue());
            break;
          case 6:
            product.setUnitType(currentCell.getStringCellValue());
            break;
          case 7:
            product.setCategory(currentCell.getStringCellValue());
            break;
          case 8:
            product.setDistributorRoot(currentCell.getStringCellValue());
            break;
          case 9:
            product.setDistributorLeaf(currentCell.getStringCellValue());
            break;

          case 10:
            product.setManafacturer(currentCell.getStringCellValue());
            break;
          case 11:
            product.setQuantity((int)currentCell.getNumericCellValue());
            break;
          case 12:
            product.setPrice(String.valueOf(currentCell.getNumericCellValue()) );
          case 13:
            product.setTotal(String.valueOf(currentCell.getNumericCellValue()) );

            break;
          default:
            break;
          }

          cellIdx++;
        }

        Products.add(product);
      }

      workbook.close();

      return Products;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}
