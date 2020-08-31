package com.netmoor.beseller.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Account.
 *
 * @author Nikolay_Batov
 */
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 6, max = 50)
    @Column(unique = true, nullable = false)
    private String login;

    @NotNull
    @Size(min = 8, max = 50)
    private String password;

    @NotNull
    @Email
    @Column(unique = true, nullable = false)
    private String email;
}
