package com.dgut.repair.service;

import com.dgut.repair.Response;
import com.dgut.repair.dao.Order;
import com.dgut.repair.dao.OrderRepository;
import com.dgut.repair.dao.Repairer;
import com.dgut.repair.dao.RepairerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    private RepairerRepository repairerRepository;
    public int addOrder(Order order) {
        orderRepository.save(order);
        return order.getOrdered();
    }
    @Transactional
    public int orderAccepted(int order_id){
        orderRepository.acceptOrderStatusById(order_id);
        return order_id;
    }
    @Transactional
    public int orderFinished(int order_id){
        orderRepository.finishOrderStatusById(order_id);
        Order order= orderRepository.findByOrdered(order_id);
        Repairer repairer = repairerRepository.findByName(order.getName());
        //增加接单数
        if (repairer != null) {
            // 增加orders的值
            repairer.setOrders(repairer.getOrders() + 1);

            // 更新数据库
            repairerRepository.save(repairer);
        }
        return order_id;
    }
    @Transactional
    public List<Order> listOrder(){
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrderById(int order_id) {
        Optional<Order> order = orderRepository.findById(order_id);

    }
    @Override
    public Response listUserOrder(int id){
        List<Order> list = orderRepository.findByUserid(id);
        return Response.newSuccess(list);
    }
    @Override
    public Response updateOrder(Order order) {
        Order originalOrder = orderRepository.findById(order.getOrdered()).orElse(null);
        if (originalOrder.getRepair_status() != 0) {
            System.out.println(originalOrder.getRepair_status());
            return Response.newFail("该订单已接单或已完成，无法修改。");
        } else {
            originalOrder.setLocation(order.getLocation());
            originalOrder.setCategory(order.getCategory());
            originalOrder.setDescription(order.getDescription());
            originalOrder.setUser_phone(order.getUser_phone());

            // 保存更新后的订单信息到数据库中
            orderRepository.save(originalOrder);
            return Response.newSuccess(originalOrder);
        }
    }
    public Response cacelOrder(int id){
        Order originalOrder = orderRepository.findById(id).orElse(null);
        if(originalOrder==null){
            return Response.newFail("null错误");
        } else if (originalOrder.getRepair_status() != 1) {
            System.out.println(originalOrder.getRepair_status());
            return Response.newFail("撤销接单失败");
        } else if(originalOrder!=null){
            originalOrder.setRepair_status(0);
            // 保存更新后的订单信息到数据库中
            orderRepository.save(originalOrder);
            return Response.newSuccess(originalOrder);
        }
        return null;
    }
    }
