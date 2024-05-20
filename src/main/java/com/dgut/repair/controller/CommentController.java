package com.dgut.repair.controller;

import com.dgut.repair.Response;
import com.dgut.repair.dao.Comment;
import com.dgut.repair.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/comment")
    public Response AddComment(@RequestBody Comment comment) {

        return commentService.addComment(comment);
    }
    @GetMapping("/comment/{id}")
    public Response GetComment(@PathVariable int id) {
        return commentService.getComment(id);
    }
}
