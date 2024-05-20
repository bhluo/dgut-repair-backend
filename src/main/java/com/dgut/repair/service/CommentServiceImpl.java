package com.dgut.repair.service;

import com.dgut.repair.Response;
import com.dgut.repair.dao.Comment;
import com.dgut.repair.dao.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    public Response addComment(Comment comment){
        commentRepository.save(comment);
        return Response.newSuccess(comment);
    }

    public Response getComment(int id) {
        if(commentRepository.findByOrderid(id)!=null){
            System.out.println(commentRepository.findByOrderid(id));
        return Response.newSuccess(commentRepository.findByOrderid(id));
    } else{
            return Response.newFail("未评价");
        }
        }
}
