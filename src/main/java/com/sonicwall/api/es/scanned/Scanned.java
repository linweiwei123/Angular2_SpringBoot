package com.sonicwall.api.es.scanned;

import io.swagger.annotations.*;
import springfox.documentation.annotations.*;
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
import com.sonicwall.model.es.scanned.*;
import com.sonicwall.model.*;
import com.github.javafaker.Faker;

@RestController
@ApiIgnore
@RequestMapping(value = "/scanned", produces = { "application/json" })
@Api(tags = {"ES_Mail Scan"})
public class Scanned {
  @ApiOperation(value = "Gets all the files that has been scanned in last 30 days", response = ScannedResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "list of files scanned in last 30 days.", response = ScannedResponse.class) })
  @RequestMapping(method = RequestMethod.GET)
  public ScannedResponse getScanedFiles(
    @ApiParam(value = "") @RequestParam(value = "pageSize",   required = false) Integer pageSize,
    @ApiParam(value = "") @RequestParam(value = "pageNumber", required = false) Integer pageNumber
  ) {
    
      ScannedResponse resp = new ScannedResponse();
      resp.setSuccess(true);
      Faker faker = new Faker();
      for (int i=0; i < 10000 ;i++) {
          ScannedModel scanned = new ScannedModel();
          scanned.setFilename(faker.company().name());
          resp.getData().add(scanned);        
      }
      // do some magic!
      resp.setTotal(10);
      return resp;
  }

}
