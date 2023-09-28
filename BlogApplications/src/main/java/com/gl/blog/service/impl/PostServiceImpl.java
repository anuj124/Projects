package com.gl.blog.service.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.gl.blog.entity.Post;
import com.gl.blog.exception.ResourceNotFoundException;
import com.gl.blog.payload.PostDto;
import com.gl.blog.payload.PostResponse;
import com.gl.blog.repository.PostRepository;
import com.gl.blog.service.PostService;
@Repository
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	private ModelMapper mapper;
	public PostServiceImpl(PostRepository postRepository, ModelMapper mapper) {
		this.postRepository = postRepository;
		this.mapper= mapper;
	}

	@Override
	public PostDto createPost(PostDto postDto) {
		Post post = mapToEntity(postDto);
		Post newPost = postRepository.save(post);
		PostDto postResponse = mapToDto(newPost);
		return postResponse;
	}

	
	@Override
	public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equals(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Post> posts = postRepository.findAll(pageable);
		List<Post> listOfPost =posts.getContent();
		List<PostDto> content = listOfPost.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
		PostResponse postResponse= new PostResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(pageNo);
		postResponse.setPageSize(pageSize);
		postResponse.setTotalElement(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());
		
		return postResponse;
	}

	@Override
	public PostDto getPostByID(long id) {
		Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id ));
		return mapToDto(post);
	}

	@Override
	public PostDto updatePost(PostDto postDto, long id) {
		Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id ));
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		Post updatedPost = postRepository.save(post);
		return mapToDto(updatedPost);
	}

	@Override
	public void deletePostById(long id) {
		Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id ));
		postRepository.delete(post);
		
	}
	
	private PostDto mapToDto(Post post) {
		PostDto postDto = mapper.map(post, PostDto.class );
		//PostDto postDto =new PostDto();
		//postDto.setId(newPost.getId());
		//postDto.setTitle(newPost.getTitle());
		//postDto.setDescription(newPost.getDescription());
		//postDto.setContent(newPost.getContent());
		return postDto;
	}

	private Post mapToEntity(PostDto postDto) {
		Post post = mapper.map(postDto, Post.class );
		//post.setId(postDto.getId());
		//post.setTitle(postDto.getTitle());
		//post.setDescription(postDto.getDescription());
		//post.setContent(postDto.getContent());
		return post;
	}


}
