package com.sonicwall.api.msw.notification;

import com.sonicwall.api.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import java.util.*;
import com.sonicwall.model.*;
import com.sonicwall.model.msw.notification.*;
import com.github.javafaker.Faker;
import com.sonicwall.repo.msw.NotificationPreferenceRepo;


@RestController
@RequestMapping(value = "/api/users", produces = { "application/json" })
@Api(tags = {"Notifications"})
public class NotificationPreferences {

  @Autowired
  private NotificationPreferenceRepo notificationPrefRepo;

  //@ApiOperation(value = "List notification preferences for a user", response = NotificationPreferenceResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "List notification preferences for a user", response = NotificationPreferenceResponse.class) })
  @RequestMapping(value = "{username}/notification-preferences", method = RequestMethod.GET)
  public NotificationPreferenceResponse getNotificationPreferences(@PathVariable String username) throws NotFoundException {
    
      NotificationPreferenceResponse resp = new NotificationPreferenceResponse();
      final List<NotificationPreferenceModel> notificationPrefModelList = notificationPrefRepo.findByUsername(username);
      resp.setSuccess(true);
      for (NotificationPreferenceModel itr : notificationPrefModelList) {
        resp.getData().add(itr);
		  }
      resp.setTotal(notificationPrefModelList.size());
      return resp;
  }


  //@ApiOperation(value = "Update notification preferences for a user", response = BaseResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Update notification preferences for a user", response = BaseResponse.class) })
  @RequestMapping(value = "{username}/notification-preferences", method = RequestMethod.POST)
  public BaseResponse updateNotificationPreferences(@PathVariable String username, @RequestBody List<NotificationPreferencePost> newNotificationPreferencesList) throws NotFoundException {
    BaseResponse resp = new BaseResponse();

    //Get the notification Preferences of the user   
    final List<NotificationPreferenceModel> userNotificationPrefList = notificationPrefRepo.findByUsername(username);

    if (userNotificationPrefList.size() <= 0){
        resp.setSuccess(false);
        resp.setMsg( String.format("User not found : %s", username));
    }
    else{
        resp.setSuccess(true);
        for (NotificationPreferencePost newPreference : newNotificationPreferencesList){
             NotificationPreferenceModel notificationPref = userNotificationPrefList.stream().filter(o -> o.getNotifyTypeId().equals(newPreference.getNotifyTypeId())).findFirst().orElse(null);
             if (notificationPref != null){
                 notificationPref.setIsEnabled(newPreference.getIsEnabled());
                 notificationPrefRepo.save(notificationPref);
             }
        }
        resp.setMsg("Preference Updated");
    }
    return resp;
  }


}