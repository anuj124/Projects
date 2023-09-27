package com.gl.blog.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

	private List<PostDto> content;
	private int pageNo;
	private int pageSize;
	private Long totalElement;
	private int totalPages;
	private boolean last;
}
