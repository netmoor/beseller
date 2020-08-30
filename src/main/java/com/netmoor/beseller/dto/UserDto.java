package com.netmoor.beseller.dto;

import lombok.Data;

import javax.validation.constraints.Email;

/**
 * User.
 *
 * @author Nikolay_Batov
 */
@Data
public class UserDto {

    private String fistName;

    private String login;

    private String password;

    @Email
    private String email;
}
