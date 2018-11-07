package com.zxy.demo.entity;

import java.io.Serializable;

public class UserAddress implements Serializable {
    private static final long serialVersionUID = 8655851615465363473L;
    private Long id;
    private String province;
    private String city;
    private String district;
    public UserAddress(Long id,String province,String city,String district){
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
