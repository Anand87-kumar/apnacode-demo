package com.anand.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anand.springboot.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
