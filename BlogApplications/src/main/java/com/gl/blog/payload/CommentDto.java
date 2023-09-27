package com.gl.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {

	private long id;
	@NotEmpty(message = "Name should not be empty")
	private String name;
	@NotEmpty(message = "Email should not be empty")
	private String email;
	@NotEmpty
	@Size(min = 10, message = "Comment body should have atleast 10 characters")
	private String body;

}
