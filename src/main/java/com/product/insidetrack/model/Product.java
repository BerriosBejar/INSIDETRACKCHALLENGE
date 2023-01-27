package com.product.insidetrack.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Product {
    private Date purchaseDate;
    private String invoice;
    private String customerRoot;
    private String customerLeaf;
    private String productDescription;
    private String packSize;
    private String unitType;
    private String category;
    private String distributorRoot;
    private String distributorLeaf;
    private String manafacturer;
    private Integer quantity;
    private String price;
    private String total;
    
    public Product() {
    }
   
    public String getInvoice() {
        return invoice;
    }
    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }
    public String getCustomerRoot() {
        return customerRoot;
    }
    public void setCustomerRoot(String customerRoot) {
        this.customerRoot = customerRoot;
    }
    public String getCustomerLeaf() {
        return customerLeaf;
    }
    public void setCustomerLeaf(String customerLeaf) {
        this.customerLeaf = customerLeaf;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    public String getPackSize() {
        return packSize;
    }
    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }
    public String getUnitType() {
        return unitType;
    }
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDistributorRoot() {
        return distributorRoot;
    }
    public void setDistributorRoot(String distributorRoot) {
        this.distributorRoot = distributorRoot;
    }
    public String getManafacturer() {
        return manafacturer;
    }
    public void setManafacturer(String manafacturer) {
        this.manafacturer = manafacturer;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public String getDistributorLeaf() {
        return distributorLeaf;
    }
    public void setDistributorLeaf(String distributorLeaf) {
        this.distributorLeaf = distributorLeaf;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
