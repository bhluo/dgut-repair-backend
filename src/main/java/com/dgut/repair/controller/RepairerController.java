package com.dgut.repair.controller;

import com.dgut.repair.Response;
import com.dgut.repair.service.RepairerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RepairerController {
    @Autowired
    private RepairerService repairerService;

    @GetMapping("/repairer/{name}")
    public Response getRepairer(@PathVariable String name) {
        System.out.println("1");
        return repairerService.getRepairer(name);
    }

    @PostMapping("/repairer/comment")
    public Response commentRepairer(@RequestParam("id") int id,@RequestParam("comment") int comment) {
        System.out.println(id);
        return repairerService.commentRepairer(id,comment);
    }

}
