package com.wind.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.util.Date;

public class Comm {
    private int id;
    @NotEmpty(message="姓名不能为空")
    private String name;
    private String phone;
    @NotEmpty(message="请选择景点")
    private String land;
    @Min(value = 1,message = "请选择成人人数")
    private int adults;
    @Min(value = 0,message = "请选择小孩人数")
    private int child;
    private String date;
    private int uid;

    public Comm() {
    }

    public Comm(int id, String name, String phone, String land, int adults, int child, String date, int uid) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.land = land;
        this.adults = adults;
        this.child = child;
        this.date = date;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Comm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", land='" + land + '\'' +
                ", adults=" + adults +
                ", child=" + child +
                ", date='" + date + '\'' +
                ", uid=" + uid +
                '}';
    }
}
