package com.gl.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
