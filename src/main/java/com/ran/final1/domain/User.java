package com.ran.final1.domain;

import lombok.Data;

@Data
public class User {
    private Integer userId;

    private String userName;

    private String userSex;

    private String userType;

    private String userAccount;

    private String userPassword;
}