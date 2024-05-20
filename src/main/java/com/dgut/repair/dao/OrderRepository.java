package com.dgut.repair.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Modifying
    @Query("UPDATE Order o SET o.repair_status = 1 WHERE o.ordered = :id")
    void acceptOrderStatusById(int id);
    @Modifying
    @Query("UPDATE Order o SET o.repair_status = 2 WHERE o.ordered = :id")
    void finishOrderStatusById(int id);
    List<Order> findByUserid(Integer userid);
    Order findByOrdered(Integer ordered);
}
