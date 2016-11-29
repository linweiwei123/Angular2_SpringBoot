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
@RequestMapping(value = "/mail/junk", produces = { "application/json" })
public class JunkBoxApi {
  @ApiOperation(value = "Get list of emails from junkbox", response = JunkBoxResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Get list of emails from junkbox", response = JunkBoxResponse.class) })
  @RequestMapping(method = RequestMethod.GET)
  public JunkBoxResponse getJunkBoxEmails(
    @RequestParam(value = "start"  ,  defaultValue="1",  required = false) Integer start,
    @RequestParam(value = "limit"  ,  defaultValue="100" ,  required = false) @ApiParam(value = "between 1 to 1000 allowed" ) Integer limit,
    @RequestParam(value = "page"   ,  required = false) Integer page,
    @RequestParam(value = "filter" ,  required = false) String filter
  ) throws NotFoundException {
    
      JunkBoxResponse resp = new JunkBoxResponse();
      resp.setSuccess(true);
      Faker faker = new Faker();
      if (limit == null || limit < 1){
        limit = 1000;
      }
      else{
        limit =  (limit > 1000) ? 1000 : limit;
      }
      
      Date startDate, endDate;
      Calendar cal = Calendar.getInstance();
      endDate = new Date();
      cal.setTime(endDate);
      cal.add(Calendar.MONTH, -2);
      startDate = cal.getTime();

      for (int i=0; i < limit ;i++) {
          JunkBoxModel junkMail = new JunkBoxModel();
          //junkMail.setReceiveTime(faker.date().between(new Date(System.currentTimeMillis() - 3600 * 1000 * 24 * 60), new Date()) ) ;  // Past 60 Days
          junkMail.setReceiveTime(faker.date().between(startDate, endDate) ) ;  // Past 60 Days
          junkMail.setFrom(faker.internet().emailAddress());
          junkMail.setTo(faker.internet().emailAddress());
          junkMail.setSubject(faker.shakespeare().asYouLikeItQuote());
          junkMail.setThreat(JunkBoxModel.ThreatEnum.valueOf(faker.options().option("spam", "virus", "phishing", "likely_spam", "likely_virus", "likely_phishing", "dha", "policy", "likely_spoof").toLowerCase()));
          junkMail.setMsgId(faker.crypto().md5());
          junkMail.setMlfId(faker.crypto().sha1());
          junkMail.setAttachment(faker.bool().bool());
          resp.getData().add(junkMail);
      }
      // do some magic!
      resp.setTotal(1000000);
      return resp;
  }

}
