package com.dgut.repair.service;

import com.dgut.repair.Response;
import com.dgut.repair.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RepairerRepository repairerRepository;

    public Response addComment(int userid,int orderid,String data,int comment){
        Comment comment1 = new Comment();
        comment1.setUserid(userid);
        comment1.setOrder_id(orderid);
        comment1.setData(data);
        System.out.println("orderid:"+orderid);
        commentRepository.save(comment1);
        Order order = orderRepository.findByOrderid(orderid);
        Repairer repairer = repairerRepository.findByName(order.getName());
        System.out.println(repairer);
        if(comment==0){
            repairer.setPositive_reviews(repairer.getNegative_reviews()+1);
        }else if(comment==1){
            repairer.setNeutral_reviews(repairer.getNeutral_reviews()+1);
        }else{
            repairer.setNegative_reviews(repairer.getNegative_reviews()+1);
        }
        repairerRepository.save(repairer);
        return Response.newSuccess(comment1);
    }

    public Response getComment(int id) {
        System.out.println(commentRepository.findByOrderid(id));
        if(commentRepository.findByOrderid(id)!=null){
            System.out.println(commentRepository.findByOrderid(id));
            System.out.println("222222222222222");
        return Response.newSuccess(commentRepository.findByOrderid(id));
    } else{
            System.out.println("33333333333");
            return Response.newFail("未评价");
        }
    }
}
