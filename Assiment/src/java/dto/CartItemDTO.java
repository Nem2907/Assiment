/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author PhamBaoPhi
 */
public class CartItemDTO {
     private int id;
    private int accountId;
    private int productId;
    private int quantity;
    private String productName;
    private String productImage;
    private double total;
    private LocalDateTime dateAdded;

    public CartItemDTO(int id, int accountId, int productId, int quantity,
            String productName, String productImage, double total,
            LocalDateTime dateAdded) {
        this.id = id;
        this.accountId = accountId;
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productImage = productImage;
        this.total = total;
        this.dateAdded = dateAdded;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateAdded.format(formatter);
    }

    public int getAccountId() {
        return accountId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public double getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setDate(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CartItem{" + "id=" + id + ", accountId=" + accountId + ", productId=" + productId + ", quantity=" + quantity + ", productName=" + productName + ", productImage=" + productImage + ", total=" + total + ", dateAdded=" + dateAdded + '}';
    }
}
