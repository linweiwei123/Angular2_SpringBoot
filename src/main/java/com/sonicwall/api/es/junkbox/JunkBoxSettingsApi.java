package com.sonicwall.api.es.junkbox;
import com.sonicwall.api.*;
import io.swagger.annotations.*;
import springfox.documentation.annotations.*;

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
import com.sonicwall.model.es.junkbox.*;
import com.github.javafaker.Faker;


@RestController
@ApiIgnore
@Api(tags = {"ES_Junk-Box"})
@RequestMapping(value = "/mail/junkbox-settings", produces = { "application/json" })
public class JunkBoxSettingsApi {
  @ApiOperation(value = "Get junkbox settings", response = JunkBoxSettingsResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Get list of emails from junkbox", response = JunkBoxSettingsResponse.class) })
  @RequestMapping(method = RequestMethod.GET)
  public JunkBoxSettingsResponse getJunkBoxSettingsResponse() throws NotFoundException {
      JunkBoxSettingsResponse.UnjunkActionEnum unjunkActionEnum =JunkBoxSettingsResponse.UnjunkActionEnum.ask_user;
      JunkBoxSettingsResponse.TagSettings junkTag           = new JunkBoxSettingsResponse.TagSettings(true, "[junk]");
      JunkBoxSettingsResponse.TagSettings junkInAllowedList = new JunkBoxSettingsResponse.TagSettings(true, "[junkInAllowedList]");
      JunkBoxSettingsResponse.TagSettings junkInPloicyList  = new JunkBoxSettingsResponse.TagSettings(true, "[junkInPloicyList]");
      JunkBoxSettingsResponse.TagSettings processedItem     = new JunkBoxSettingsResponse.TagSettings(true, "[processedItem]");

      JunkBoxSettingsResponse resp = new JunkBoxSettingsResponse(30, unjunkActionEnum, junkTag, junkInAllowedList, junkInPloicyList, processedItem);

      resp.setSuccess(true);
      //resp.setRetentionInDays(30);
      //resp.junkTag.setMessage("[JUNK]");
      //resp.junkTag.setEnabled(true);
      
      //resp.setUnjunkAction();
      //resp.junkInAllowedList
      //resp.junkInPloicyList
      //resp.processedItem
      return resp;
  }

}
