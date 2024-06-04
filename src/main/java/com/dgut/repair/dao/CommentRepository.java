package com.dgut.repair.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Comment findByOrderid(Integer orderid);
}
