package com.product.insidetrack.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.product.insidetrack.helper.ExcelHelper;
import com.product.insidetrack.model.Product;
import com.product.insidetrack.service.ProductService;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService {
    private final static Logger LOGGER = Logger.getLogger("com.product.insidetrack.service.impl.ProductServiceImpl");

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        File initialFile = new File("src/main/resources/database.xlsx");
        try {
            InputStream targetStream = new FileInputStream(initialFile);
            return ExcelHelper.excelToProducts(targetStream);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            LOGGER.info("Error"+e.getMessage());
            e.printStackTrace();
        }
    
        return null;
    }
    
}
