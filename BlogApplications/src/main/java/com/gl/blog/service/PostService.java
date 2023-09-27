package com.gl.blog.service;

import org.springframework.stereotype.Service;

import com.gl.blog.payload.PostDto;
import com.gl.blog.payload.PostResponse;
@Service
public interface PostService {

	PostDto createPost(PostDto postDto);
	
	PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
	
	PostDto getPostByID(long id);
	
	PostDto updatePost(PostDto postDto, long id);
	
	void deletePostById(long id);
}
