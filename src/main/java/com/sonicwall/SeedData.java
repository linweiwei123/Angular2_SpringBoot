package com.sonicwall;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

// User Model and Repo
import com.sonicwall.model.security.User;
import com.sonicwall.model.security.Role;
import com.sonicwall.repo.UserRepository;

// Notification Model and Repo
import com.sonicwall.model.msw.notification.NotificationPreferenceModel;
import com.sonicwall.repo.msw.NotificationPreferenceRepo;

@Service
public final class SeedData {

	//Users
	public void insertDefaultUsers(
		UserRepository userRepo) {
		System.out.println("[ *** Mrin *** ]: Adding Users");
		addUser(userRepo, "admin"  , "admin");
		addUser(userRepo, "user"   , "user");
		addUser(userRepo, "demo"   , "demo");
		addUser(userRepo, "inactive", "inactive");

		addUser(userRepo, "nitinsw", "pwd4dev");
	}
	private void addUser(UserRepository userRepo, String username, String password) {
		User user = new User();
		user.setUserName(username);
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		user.setRole(username.equals("admin") ? Role.ADMIN: Role.USER);
		user.setCompany("sonicwall");
		user.setPendingActivation(username.equals("inactive")?true:false);
		userRepo.save(user);
	}

	//Notification Preferences
	public void insertNotificationPref(NotificationPreferenceRepo notificationPrefRepo){
		System.out.println("[ *** Mrin *** ]: Adding Notification Preferences for users");
		addNotificationPreferences(notificationPrefRepo, "admin");
		addNotificationPreferences(notificationPrefRepo, "nitinsw");
		addNotificationPreferences(notificationPrefRepo, "demo");
	}
	private void addNotificationPreferences(NotificationPreferenceRepo notificationPrefRepo, String username ) {
		Integer i;
		for (i=1;i<=8;i++){
			NotificationPreferenceModel notificationPrefModel = new NotificationPreferenceModel();
			notificationPrefModel.setUsername(username);
			notificationPrefModel.setNotifyTypeId(i.toString());
			notificationPrefRepo.save(notificationPrefModel);
		}
	}
	
}



