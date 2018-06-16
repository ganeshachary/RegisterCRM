package com.vidvels.registercrm;

/**
 * Created by psganesh on 16/06/18.
 */

public class RegisterShop {

    String name,mobile,email,shopname,shopaddress,password;

    public RegisterShop() {
    }


    public RegisterShop(String name, String mobile, String email, String shopname, String shopaddress, String password) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.shopname = shopname;
        this.shopaddress = shopaddress;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopaddress() {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
