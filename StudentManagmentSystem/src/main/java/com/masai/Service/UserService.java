package com.masai.Service;

import com.masai.Exception.UserException;
import com.masai.dto.UserDto;

public interface UserService {

	
    public UserDto registerUser(UserDto userDTO) throws UserException;
	
	public UserDto registerStudentAsUser(UserDto userDTO) throws UserException;
	
	
}
