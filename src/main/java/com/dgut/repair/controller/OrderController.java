package com.dgut.repair.controller;

import com.dgut.repair.Response;
import com.dgut.repair.dao.Order;
import com.dgut.repair.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/order")
    public Response addOrder(@RequestBody Order order) {
        return Response.newSuccess(orderService.addOrder(order));
    }
    @PutMapping("/order/accept/{id}")
    public Response orderAccepted(@PathVariable Integer id) {
        return Response.newSuccess(orderService.orderAccepted(id));
    }
    @PutMapping("/order/finish/{id}")
    public Response orderFinished(@PathVariable Integer id) {
        return Response.newSuccess(orderService.orderFinished(id));
    }
    //用户界面
    @GetMapping("/order/userlist/{id}")
    public Response orderUserList(@PathVariable Integer id) {
        return orderService.listUserOrder(id);
    }
    //管理员界面
    @GetMapping("/order/adminlist")
    public Response orderList() {
        return Response.newSuccess(orderService.listOrder());
    }
    @DeleteMapping("/order/delete/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrderById(id);
    }
    @PutMapping("/order/update")
    public Response updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }
//    @GetMapping("order/comment")
    @PutMapping("/order/admincacel/{id}")
    public Response admincacelOrder(@PathVariable Integer id) {
        return orderService.cacelOrder(id);
    }
}
