package com.sonicwall.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sonicwall.model.*;
//import javax.persistence.*;
import lombok.*;
//@Entity
public class UserInfoResponse extends BaseResponse {

    @Getter @Setter private User data = new User();
}