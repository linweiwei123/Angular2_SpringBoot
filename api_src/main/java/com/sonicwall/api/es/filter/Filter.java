package com.sonicwall.api.es.filter;
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
import com.sonicwall.model.es.filter.*;

import com.github.javafaker.Faker;

@RestController
@ApiIgnore
@RequestMapping(value = "/mail/filters", produces = { "application/json" })
@Api(tags = {"ES_Mail-Filters"})
public class Filter {
  @ApiOperation(value = "List of inbound and oudbound filters", response = FilterResponse.class)
  @ApiResponses(value = { @ApiResponse(code = 200, message = "List of inbound and oudbound filters", response = FilterResponse.class) })
  @RequestMapping(method = RequestMethod.GET)
  public FilterResponse getFilters() throws NotFoundException {
    
      Faker faker = new Faker();
      FilterResponse resp =  new FilterResponse();
      String[] inBoundFilterNames = {
            "Deliver spf hardfail flagged messages from Encryption Service",
            "Strip Picture and Movie Attachments",
            "zip to junk",
            "Detect Personal Health Information (PHI) records in inbound mails",
            "Detect Personal Financial Information (PFI) records in inbound mails",
            "Junk Emails with Attachments over 4MB ",
            "RFC 822 Byte Scanwith subject from porn dictionary",
            "Detect Corporate Financial Information in inbound mails",
            "Deliver spf softfail flagged messages from Encryption Service"
      };
      String[] outBoundFilterNames = {
            "Detect Personal Financial Information (PFI) records in outbound mails ",
            "Detect Personal Health Information (PHI) records in outbound mails ",
            "Detect Corporate Financial Information in outbound mails",
            "Send Secure Mail: Deliver Message via Encryption Service "
      };

      for (int i=0; i < inBoundFilterNames.length; i++) {
          FilterModel inbound =  new FilterModel(
              i,
              inBoundFilterNames[i],
              faker.options().option("Everyone", "Domain: users@test.com", "Domain: admin@test.com", "Everyone", "Domain: admin@test.com"),  
              FilterModel.FilterActionEnum.valueOf(faker.options().option("store_in_junkbox", "delete", "strip_attachments", "add_header", "remove_header", "issue_email_notification").toLowerCase()),
              faker.bool().bool()
          );
          resp.getInboundFilters().add(inbound);
      }

      for (int i=0; i < outBoundFilterNames.length ;i++) {
          FilterModel outbound =  new FilterModel(
              i,
              outBoundFilterNames[i],
              faker.options().option("Everyone", "Domain: users@test.com", "Domain: admin@test.com", "Everyone", "Domain: admin@test.com"),  
              FilterModel.FilterActionEnum.valueOf(faker.options().option("store_in_junkbox", "delete", "strip_attachments", "add_header", "remove_header", "issue_email_notification").toLowerCase()),
              faker.bool().bool()
          );
          resp.getOutboundFilters().add(outbound);
      }
      resp.setSuccess(true);
      return resp;
  }

}
