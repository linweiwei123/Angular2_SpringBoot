package com.sonicwall.api.es.capture;
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
import com.sonicwall.model.es.capture.*;
import com.github.javafaker.Faker;

@RestController
@RequestMapping(value = "/mail", produces = { "application/json" })
@Api(tags = {"ES_Capture"})
@ApiIgnore
public class Capture {
  
  @ApiOperation(value = "List email captured by ATP", response = CaptureResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "List email captured by ATP", response = CaptureResponse.class) })
  @RequestMapping(value = "/capture", method = RequestMethod.GET)
  public CaptureResponse getCapturedEmails(
    @ApiParam(value = ""    ) @RequestParam(value = "start"  ,  defaultValue="1",  required = false) Integer start,
    @ApiParam(value = "between 1 to 1000 allowed" ) @RequestParam(value = "limit"  ,  defaultValue="100" ,  required = false) Integer limit,
    @ApiParam(value = ""    ) @RequestParam(value = "page"   ,  required = false) Integer page,
    @ApiParam(value = ""    ) @RequestParam(value = "filter" ,  required = false) String filter
  ) throws NotFoundException {
    
      CaptureResponse resp = new CaptureResponse();
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
      cal.add(Calendar.MONTH, -1);
      startDate = cal.getTime();

      for (int i=0; i < limit ;i++) {
          CaptureModel capture = new CaptureModel();

          capture.setStatus(CaptureModel.StatusEnum.valueOf(faker.options().option("action_required",  "blocked",  "scan_failed",  "scan_pending",  "scanned",  "malicious").toLowerCase()));
          //capture.setTimestamp(faker.date().between(new Date(System.currentTimeMillis() - 3600 * 1000 * 24 * 60), new Date()));  //Past 30 Days
          capture.setTimestamp(faker.date().between(startDate,endDate));  //Past 30 Days
          capture.setFilename(faker.company().name());
          capture.setProtocol(CaptureModel.ProtocolEnum.valueOf(faker.options().option("HTTP", "HTTPS", "FTP", "UDP").toUpperCase()));
          capture.setSubmitBy(faker.options().option("FW-200", "FW-800", "FW-5000i", "FW-1100a"));
          capture.setSrc("A");
          capture.setDest("B");
          capture.setIsActive(faker.bool().bool());
          resp.getData().add(capture);
      }
      // do some magic!
      resp.setTotal(1000000);
      return resp;
  }


  @ApiOperation(value = "Capture stats for last 30 days", response = CaptureStatsResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Capture stats for last 30 days", response = CaptureStatsResponse.class) })
  @RequestMapping(value = "/capture-stats", method = RequestMethod.GET)
  public CaptureStatsResponse getCapturedEmails() throws NotFoundException {
    
      CaptureStatsResponse resp = new CaptureStatsResponse();
      resp.setSuccess(true);
      Faker faker = new Faker();
      Date date   = new Date();
      Calendar cal = Calendar.getInstance();
      int blocked, scanFailed, scanPending, malicious, actionRequired, total;     
      cal.setTime(date);
      //truncate time info
      cal.set(Calendar.HOUR_OF_DAY, 0);
      cal.set(Calendar.MINUTE, 0);
      cal.set(Calendar.SECOND, 0);
      cal.set(Calendar.MILLISECOND, 0);

      for (int i=0; i < 30 ;i++) {
          CaptureStatsModel captureStats = new CaptureStatsModel();
          blocked        = 0 + (int)(Math.random() * (i%5==0?5:10));
          scanFailed     = 0 + (int)(Math.random() * (i%5==0?5:10));
          scanPending    = 0 + (int)(Math.random() * (i%5==0?5:10));
          malicious      = 0 + (int)(Math.random() * (i%5==0?25:10));
          actionRequired = 0 + (int)(Math.random() * (i%5==0?5:10));
          total = (blocked + scanFailed + scanPending + malicious + actionRequired);
          cal.add(Calendar.DATE, -1);
          captureStats.setDate(cal.getTime());
          captureStats.setBlocked(blocked);
          captureStats.setScanFailed(scanFailed);
          captureStats.setScanPending(scanPending);
          captureStats.setMalicious(malicious);
          captureStats.setActionRequired(actionRequired);
          captureStats.setTotal(total);
          resp.getData().add(captureStats);
      }
      // do some magic!
      resp.setTotal(30);
      return resp;
  }

}
