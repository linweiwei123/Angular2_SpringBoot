package com.sonicwall.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Service;

import com.sonicwall.model.security.Role;
import com.sonicwall.model.security.User;
import com.sonicwall.repo.UserRepository;
import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public final TokenUser loadUserByUsername(String username) throws UsernameNotFoundException, DisabledException {
        final User user = userRepo.findOneByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        TokenUser currentUser;
        if (user.getPendingActivation() == false){
            currentUser = new TokenUser(user);
        }
        else{
            throw new DisabledException("User is not activated (Disabled User)");
            //If pending activation return a disabled user
            //currentUser = new TokenUser(user, false);
        }
        detailsChecker.check(currentUser);
        return currentUser;
    }

    // Custom Methods
    public User getUserInfoByUserName(String userName){
        Optional objUser = Optional.of(new User());
        objUser = userRepo.findOneByUserName(userName);
        return (User)objUser.get();
    }

    public String getLoggedInUserName(){
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      return auth.getName();
    }

    public User getLoggedInUser(){
      String userName = this.getLoggedInUserName();
      //User u = new User();
      //User u2= new User();
      //Optional objUser = Optional.of(u);
      System.out.format("\nInside >> getLoggedInUser: %s", userName);
      final User user = userRepo.findOneByUserName(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
      //objUser = userRepo.findOneByUserName(userName);
      System.out.format("\nAfter Find User: %s", userName);
      /*
      if(objUser.isPresent()) {
          System.out.format("\nUserName is Present :");
        u2 = (User)objUser.get();
      }
      else{
         System.out.format("\nUserName Not found : %s", userName);    
      }
      */
      
      System.out.format("\nCurrent UserName : %s", userName);
      System.out.format("\nUser object: UserName > %s, Company > %s", user.getUserName(), user.getCompany());

      return user;
    }

    public String getLoggedInUserRoles(){
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      return auth.getName();
    }

}