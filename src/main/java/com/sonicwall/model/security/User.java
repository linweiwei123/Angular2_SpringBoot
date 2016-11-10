package com.sonicwall.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.*;
import java.util.EnumSet;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter @Setter private Long id;

    //private String username;
    @Getter @Setter private String userName;

    // Default to empty string for Auths created by JWT requests
    @JsonIgnore
    @Getter @Setter private String password = "";

    @Enumerated(EnumType.STRING)
    @Getter @Setter private Role role;
    @Getter @Setter EnumSet<Role> roles;
    @Getter @Setter private String company;
    @Getter @Setter private String phone;
    @Getter @Setter private String address1;
    @Getter @Setter private String address2;
    @Getter @Setter private String country;
    @Getter @Setter private String postal;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String secretQuestion;
    @Getter @Setter private String secretAnswer;
    @Getter @Setter private Boolean enableBetaTesting;
    @Getter @Setter private Boolean enableRenewal;
    @Getter @Setter private Boolean pendingActivation=true;

}