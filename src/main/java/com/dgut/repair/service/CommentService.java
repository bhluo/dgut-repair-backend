package com.dgut.repair.service;

import com.dgut.repair.Response;
import com.dgut.repair.dao.Comment;

public interface CommentService {
    public Response addComment(int userid,int orderid,String data,int comment);
    public Response getComment(int id);
}
