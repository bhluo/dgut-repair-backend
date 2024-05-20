package com.dgut.repair.dao;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private int id;
    private int user_id;
    @Column(name = "order_id")
    private int orderid;
    @Column(columnDefinition = "TEXT")
    private String data;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrder_id(int orderid) {
        this.orderid = orderid;
    }

}
