package com.product.insidetrack.model;

public class Product {
    private String purchaseDate;
    private String invoice;
    private String customerRoot;
    private String customerLeaf;
    private String productDescription;
    private String packSize;
    private String untilType;
    private String category;
    private String distributorRoot;
    private String manafacturer;
    private Integer quantity;
    private String price;
    private String total;
    
    public Product() {
    }
    public String getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
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
    public String getUntilType() {
        return untilType;
    }
    public void setUntilType(String untilType) {
        this.untilType = untilType;
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

}
