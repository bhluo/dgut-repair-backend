package com.dgut.repair.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "repairer")
public class Repairer {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private int user_id;
    private String name;



    private String orders;
    private int positive_reviews;
    private int neutral_reviews;
    private int negative_reviews;

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public int getPositive_reviews() {
        return positive_reviews;
    }

    public void setPositive_reviews(int positive_reviews) {
        this.positive_reviews = positive_reviews;
    }

    public int getNeutral_reviews() {
        return neutral_reviews;
    }

    public void setNeutral_reviews(int neutral_reviews) {
        this.neutral_reviews = neutral_reviews;
    }

    public int getNegative_reviews() {
        return negative_reviews;
    }

    public void setNegative_reviews(int negative_reviews) {
        this.negative_reviews = negative_reviews;
    }

    private String phone_number;


}
