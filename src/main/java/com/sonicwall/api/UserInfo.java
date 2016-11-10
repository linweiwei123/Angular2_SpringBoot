package com.sonicwall.api;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.multipart.MultipartFile;
import static org.springframework.http.MediaType.*;

import java.util.List;
import com.sonicwall.model.security.User;
import com.sonicwall.model.security.UserInfoResponse;
import javax.servlet.http.HttpServletRequest;
import com.google.common.base.Strings;
import com.sonicwall.config.security.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import com.sonicwall.repo.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RestController
@Api(tags = {"Common"})
public class UserInfo {

  @Autowired
  private UserRepository userRepo;

	@ApiOperation(value = "Gets current user information", response = UserInfoResponse.class)
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = {
		"application/json"
	})
	public UserInfoResponse getUserInformation(
		@RequestParam(value = "name", required = false) String userNameParam, HttpServletRequest req) throws NotFoundException {

		UserDetailsService userDetailService = new UserDetailsService();
    String loggedInUserName = userDetailService.getLoggedInUserName();
    
    //User user = userRepo.findOneByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    //User user = userRepo.findOneByUserName(loggedInUserName).orElseGet( () -> new User());
    User user;
		boolean provideUserDetails = false;

		if (Strings.isNullOrEmpty(userNameParam)) {
			provideUserDetails = true;
      user = userRepo.findOneByUserName(loggedInUserName).orElseGet( () -> new User());
		} 
    else if (loggedInUserName.equals(userNameParam)) {
			provideUserDetails = true;
      user = userRepo.findOneByUserName(loggedInUserName).orElseGet( () -> new User());
		} 
    else {
			//Check if the current user is superuser then provide the details of requested user
			provideUserDetails = true;
      user = userRepo.findOneByUserName(userNameParam).orElseGet( () -> new User());
		}

		UserInfoResponse resp = new UserInfoResponse();
		if (provideUserDetails) {
			resp.setSuccess(true);
		} 
    else {
			resp.setSuccess(false);
			resp.setMsgKey("NO_ACCESS");
		}
		resp.setData(user);
		return resp;
	}

	/*
	  @ApiOperation(value = "Add new user", response = UserInfoResponse.class)
	  @RequestMapping(value = "/user",  method = RequestMethod.POST, produces = { "application/json" })
	  public UserInfoResponse getUserInformation( HttpServletRequest req) throws NotFoundException {
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String username = auth.getName(); //get logged in username;
	      objUser = userRepo.findOneByUsername(username);
	      UserInfoResponse resp = new UserInfoResponse();
	      resp.setSuccess(true);
	      resp.setData(objUser.get());
	      return resp;
	  }
	*/


}