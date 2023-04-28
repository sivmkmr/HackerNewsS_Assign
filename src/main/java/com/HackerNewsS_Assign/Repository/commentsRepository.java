package com.HackerNewsS_Assign.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HackerNewsS_Assign.Entity.Comment;

public interface commentsRepository extends JpaRepository<Comment,Integer> {

}
