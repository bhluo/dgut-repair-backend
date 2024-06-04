package com.dgut.repair.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Query("UPDATE Order o SET o.repair_status = 1 WHERE o.orderid = :id")
    void acceptOrderStatusById(int id);
    @Modifying
    @Query("UPDATE Order o SET o.repair_status = 2 WHERE o.orderid = :id")
    void finishOrderStatusById(int id);
    List<Order> findByUserid(int userid);
    Order findByOrderid(int orderid);

    @Modifying
    @Query("UPDATE Order o SET o.name = :rname WHERE o.orderid = :id")
    void AddNameInOrder(int id,String rname);
}
