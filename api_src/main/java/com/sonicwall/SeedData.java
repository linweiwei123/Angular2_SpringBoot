package com.sonicwall;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.sonicwall.api.UserInfoService;
// User Model and Repo
import com.sonicwall.model.security.User;
import com.sonicwall.model.security.Role;
import com.sonicwall.repo.UserRepository;

// Notification Model and Repo
import com.sonicwall.model.msw.notification.NotificationPreferenceModel;
import com.sonicwall.repo.msw.NotificationPreferenceRepo;

@Service
public final class SeedData {

	@Autowired
	private UserInfoService userInfoService;
	//private UserRepository userRepo;

	@Autowired
	private NotificationPreferenceRepo notificationPreferenceRepo;

	//Users
	public void insertDefaultUsers() {
		System.out.println("[ *** Mrin *** ]: Adding Users");
		this.addUser("admin"  , "admin");
		this.addUser("user"   , "user");
		this.addUser("demo"   , "demo");
		this.addUser("inactive", "inactive");
		this.addUser("nitinsw", "pwd4dev");
	}

	private void addUser(String username, String password) {
		Role role = username.equals("admin") ? Role.ADMIN: Role.USER;
		boolean isPendingActivation = username.equals("inactive") ? true: false;
		User user = new User(username, password, role , username, username, isPendingActivation );
		userInfoService.insertOrSaveUser(user);
	}

	//Notification Preferences
	public void insertNotificationPref(){
		System.out.println("[ *** Mrin *** ]: Adding Notification Preferences for users");
		this.addNotificationPreferences("admin");
		this.addNotificationPreferences("nitinsw");
		this.addNotificationPreferences("demo");
	}
	private void addNotificationPreferences(String username ) {
		Integer i;
		for (i=1;i<=8;i++){
			NotificationPreferenceModel notificationPrefModel = new NotificationPreferenceModel();
			notificationPrefModel.setUsername(username);
			notificationPrefModel.setNotifyTypeId(i.toString());
			this.notificationPreferenceRepo.save(notificationPrefModel);
		}
	}

}



