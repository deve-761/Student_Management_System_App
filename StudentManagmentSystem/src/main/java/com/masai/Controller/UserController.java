package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.Service.UserService;
import com.masai.dto.UserDto;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/admin/register")
	public ResponseEntity<UserDto> registerAdminHandler(@Valid @RequestBody UserDto userDTO	) throws UserException {
		
		UserDto registeredUser =  userService.registerUser(userDTO) ;
		
		return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED) ;
	}

}
