package dto;

import java.sql.Date;

public class OrderDTO {
    private String orderID;
    private int accountID;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private double freight;
    private String shipAddress;

    public OrderDTO(String orderID, int accountID, Date orderDate, Date requiredDate, Date shippedDate, double freight, String shipAddress) {
        this.orderID = orderID;
        this.accountID = accountID;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.freight = freight;
        this.shipAddress = shipAddress;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderID=" + orderID + ", accountID=" + accountID + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate + ", shippedDate=" + shippedDate + ", freight=" + freight + ", shipAddress=" + shipAddress + '}';
    }

}
