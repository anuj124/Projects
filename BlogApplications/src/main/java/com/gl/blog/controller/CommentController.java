package com.gl.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.blog.payload.CommentDto;
import com.gl.blog.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class CommentController {

	private CommentService commentService;

	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}

	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment( @PathVariable(value = "postId") long postId,
			@Valid @RequestBody CommentDto commentDto) {
		return new ResponseEntity<CommentDto>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
	}

	@GetMapping("posts/{postId}/comments")
	public List<CommentDto> getCommentByPostId(@PathVariable(value = "postId") Long postId) {
		return commentService.getCommentsByPostId(postId);
	}

	@GetMapping("posts/{postId}/comments/{id}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") Long postId,
			@PathVariable(value = "id") Long commentId) {

		return new ResponseEntity<CommentDto>(commentService.getCommentById(postId, commentId), HttpStatus.OK);
	}

	@PutMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") Long postId,
			@PathVariable(value = "id") Long commentId, @RequestBody CommentDto commentDto) {
		return new ResponseEntity<CommentDto>(commentService.updateComment(postId, commentId, commentDto),
				HttpStatus.OK);
	}
	
	@DeleteMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable(value= "postId") Long postId, @PathVariable(value="id") Long commentId){
		commentService.deleteComment(postId, commentId);
		return new ResponseEntity<String>("Comment id Deleted Successfully", HttpStatus.OK);
	}

}
