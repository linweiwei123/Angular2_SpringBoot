package com.sonicwall.api;

import java.util.List;
import com.sonicwall.model.*;
import com.google.common.base.Strings;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.sonicwall.repo.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.context.annotation.Bean;
import com.sonicwall.model.security.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Service
public class UserInfoService {

  @Autowired
  private UserRepository userRepo;

	public String getLoggedInUserName(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}


	public User getLoggedInUser() {
		String loggedInUserName = this.getLoggedInUserName();
		System.out.format("\n1. Inside >> getLoggedInUser: %s", loggedInUserName);
		User user = this.getUserInfoByUserName(loggedInUserName);
		System.out.format("\n2. After Find User: %s", loggedInUserName);
		return user;
	}

  public User getUserInfoByUserName(String userName){
		User user = this.userRepo.findOneByUserName(userName).orElseGet( () -> new User());
		return user;
  }

	public boolean addUser(User user) {
		user.setCompany("online");
		user.setPendingActivation(true);
		this.userRepo.save(user);
		return true;
	}

}