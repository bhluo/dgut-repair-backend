package com.dgut.repair.dao;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="orders")
public class Order {
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_id")
    private int orderid;
    private String location;
    private String category;
    private int repair_status;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "user_id")
    private int userid;
    private String user_phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRepair_status() {
        return repair_status;
    }

    public void setRepair_status(int repair_status) {
        this.repair_status = repair_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return userid;
    }

    public void setUser_id(int userid) {
        this.userid = userid;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }




}
