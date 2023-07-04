package com.masai.Configaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.Repositry.UserRepo;
import com.masai.bean.User;


@Service
public class StudentDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
        User user = userRepo.findByMobileNumber(username);
		
		if(user == null)
			throw new UsernameNotFoundException("Invalid MobileNumber provided") ;
		
		return new StudentDetails(user);
		
		
	}

}
