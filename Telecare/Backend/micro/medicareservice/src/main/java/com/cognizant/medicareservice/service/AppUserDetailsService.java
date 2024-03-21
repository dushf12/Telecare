package com.cognizant.medicareservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.medicareservice.model.Users;
import com.cognizant.medicareservice.repository.UsersRepository;



@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UsersRepository userRepository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//System.out.println("............."+username);
        Users user=userRepository.findByUsername(username);
       // System.out.println(",,,,,,,,,,,"+user);
        if(user.getUsername()==null)
        {
                        throw new UsernameNotFoundException("User is not found");
        }
        
         if(user.getApprove().equals("P")){
        	//System.out.println(",,,,,,,,,,,,,,,,"+user.getApprove());
                        throw new UsernameNotFoundException("Status of manager is pending");
        }
        
        else{
                        AppUser app=new AppUser(user);
                        System.out.println(app);
                        return app;
        }


	}

}