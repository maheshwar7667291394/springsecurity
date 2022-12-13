package com.masai.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.mocdel.CurrentUserSesson;
import com.masai.mocdel.LoginDao;
import com.masai.mocdel.User;
import com.masai.repo.CurrentUserDao;
import com.masai.repo.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class CurrentUserSessonServiceimpl implements CurrentUserSessonService{
	
	@Autowired
	public UserDao udao;
	
	@Autowired
	public CurrentUserDao cudao;

	@Override
	public CurrentUserSesson LoginUser(LoginDao login) throws UserException {
		
		Optional<User> ruser=udao.findById( login.getEmail());
		if(ruser.isEmpty()) {
			throw new UserException("plese register first");
		}
		
		Optional<CurrentUserSesson> cuser=cudao.findById(login.getEmail());
		if(cuser.isPresent()) {
			throw new UserException("User already logedin by this number");
		}
		
		User user=ruser.get();
		
		if(user.getPassword().equals(login.getPaassword())) {
			String key=RandomString.make(6);
			CurrentUserSesson cuser1=new CurrentUserSesson(login.getEmail(), key, login.getPaassword());
			return cudao.save(cuser1);
		}
		
		
	   throw new UserException("Enter valid password");
	}

	@Override
	public String logout(String uuid) throws UserException {
		  CurrentUserSesson cusersesson=cudao.findByuuid(uuid);
		  if(cusersesson==null) {
			  throw new UserException("user not login by this uuid");
		  }
		  cudao.delete(cusersesson);

	   return "user logout sucussesfull";
	}

	

}
