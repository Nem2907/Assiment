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
public class SupplierDTO {

    private String supplierID;
    private String companyName;
    private String address;
    private String phone;

    public SupplierDTO(String supplierID, String companyName, String address, String phone) {
        this.supplierID = supplierID;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplierID=" + supplierID + ", companyName=" + companyName + ", address=" + address + ", phone=" + phone + '}';
    }

}
