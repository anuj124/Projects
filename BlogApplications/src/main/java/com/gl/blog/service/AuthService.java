package com.gl.blog.service;

import com.gl.blog.payload.LoginDto;
import com.gl.blog.payload.RegisterDto;

public interface AuthService {

	
	String login(LoginDto loginDto);
	
	String register(RegisterDto registerDto);
}
