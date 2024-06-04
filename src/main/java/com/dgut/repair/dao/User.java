package com.dgut.repair.dao;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private int userid;
    private String user_psd;
    @Column(name = "user_name")
    private String username;
    private String user_phone;
    private int role;
    public void setUser_id(int userid) {
        this.userid = userid;
    }

    public void setUser_psd(String user_psd) {
        this.user_psd = user_psd;
    }

    public void setUser_name(String username) {
        this.username = username;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getUserid() {
        return userid;
    }

    public String getUser_psd() {
        return user_psd;
    }

    public String getUser_name() {
        return username;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public int getRole() {
        return role;
    }

}
//CREATE TABLE `user` (
//        `user_id` int(11) NOT NULL AUTO_INCREMENT,
//   `user_psd` varchar(50) NOT NULL,
//   `user_name` varchar(50) NOT NULL,
//   `user_phone` char(11) NOT NULL,
//   `role` int(2) NOT NULL COMMENT '用户权限',
//PRIMARY KEY (`user_id`)
// ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
