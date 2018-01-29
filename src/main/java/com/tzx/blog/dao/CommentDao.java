package com.tzx.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tzx.blog.model.Commentinfo;

/**
 * blog评论持久层接口
 * 
 * @author tzx
 *
 */
 @Repository
public interface CommentDao extends JpaRepository<Commentinfo, Integer> {

 }
