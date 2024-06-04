package com.dgut.repair.controller;

import com.dgut.repair.Response;
import com.dgut.repair.dao.Comment;
import com.dgut.repair.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/addcomment")
    public Response AddComment(@RequestParam String data,
                               @RequestParam int ordered,
                               @RequestParam int userid,
                               @RequestParam int comment) {
        return commentService.addComment(userid,ordered,data,comment);
    }
    @GetMapping("/comment/{id}")
    public Response GetComment(@PathVariable int id) {
        System.out.println("111111111");
        return commentService.getComment(id);
    }
}
