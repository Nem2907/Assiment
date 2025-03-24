/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author hoang
 */
public class UserDTO {
     private String UserName ;
     private String Password ;
     private String FullName ;
     private String PhoneNumber ;
     private String Email ;
     private String Role;

    public UserDTO() {
       this.UserName = "";
       this.Password = "";
       this.FullName = "";
       this.PhoneNumber = "";
       this.Email = "";
       this.Role = "User";
    }

    public UserDTO(String UserName, String Password, String FullName, String PhoneNumber, String Email, String Role) {
        this.UserName = UserName;
        this.Password = Password;
        this.FullName = FullName;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Role = Role;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "UserName=" + UserName + ", Password=" + Password + ", FullName=" + FullName + ", PhoneNumber=" + PhoneNumber + ", Email=" + Email + ", Role=" + Role + '}';
    }
     
}


