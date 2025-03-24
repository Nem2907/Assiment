/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author PhamBaoPhi
 */
public class ProductDTO {

    private int productID;
    private String productName;
    private String supplierID;
    private String categoryID;
    private int quantityPerUnit;
    private double unitPrice;
    private String description;
    private String productImage;
    private String categoryName;
    private int sale;

    public ProductDTO(int productID, String productName, String supplierID,
            String categoryID, int quantityPerUnit, double unitPrice,
            String description, String categoryName, String productImage) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.description = description;
        this.productImage = productImage;
        this.categoryName = categoryName;
        this.sale = 1;
    }

    public ProductDTO() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getSale() {
        return sale;
    }

    public String getDescription() {
        return description;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public int getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public void setQuantityPerUnit(int quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", supplierID=" + supplierID + ", categoryID=" + categoryID + ", quantityPerUnit=" + quantityPerUnit + ", unitPrice=" + unitPrice + ", description=" + description + ", productImage=" + productImage + ", categoryName=" + categoryName + ", sale=" + sale + '}';
    }
}
