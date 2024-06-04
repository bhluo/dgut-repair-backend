package com.dgut.repair.service;


import com.dgut.repair.Response;
import com.dgut.repair.dao.Order;

import java.util.List;

public interface OrderService{
    public int addOrder(Order order);
    public int orderAccepted(int order_id,String name);
    public int orderFinished(int order_id);
    public List<Order> listOrder();
    public Response deleteOrderById(int order_id);
    public Response listUserOrder(int id);
    public Response updateOrder(Order order);
    public Response cacelOrder(int id);
}
