package com.masai.ServiceIMPL;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//@org.springframework.beans.factory.annotation.Autowired(required=true)

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.Repositry.UserRepo;
import com.masai.Service.UserService;
import com.masai.bean.User;
import com.masai.dto.UserDto;


@Service
public class UserServiceIMPL implements UserService{

	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired(required = true)
	private ModelMapper modelMapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	
	
	public User dtoToUser(UserDto userDTO) {
		return this.modelMapper.map(userDTO, User.class);
	}
	
	public UserDto userToDTO(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}
	
	
	@Override
	public UserDto registerUser(UserDto userDTO) throws UserException {
		
		if(userRepo.findByMobileNumber(userDTO.getMobileNumber()) != null) {
			throw new UserException("Mobile number is already Registred " + userDTO.getMobileNumber()) ;
		}
		
		userDTO.setRole("ROLE_"+userDTO.getRole());
		userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		
		User user = dtoToUser(userDTO);
		user = userRepo.save(user);
		
		UserDto registerUser = userToDTO(user);
		return registerUser;
		
		
		
	}

	@Override
	public UserDto registerStudentAsUser(UserDto userDTO) throws UserException {
		
		if(userRepo.findByMobileNumber(userDTO.getMobileNumber()) != null) {
			throw new UserException("Mobile number is already Registred " + userDTO.getMobileNumber()) ;
		}
		userDTO.setRole("ROLE_NORMAL");
		
		User user = dtoToUser(userDTO);
		user = userRepo.save(user);
		
		UserDto registerUser = userToDTO(user);
		return registerUser;
		
		
	}

}
