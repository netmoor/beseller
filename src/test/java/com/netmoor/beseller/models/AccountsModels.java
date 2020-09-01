package com.netmoor.beseller.models;

import com.netmoor.beseller.model.Account;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * AccountsModels.
 *
 * @author Nikolay_Batov
 */
@UtilityClass
public class AccountsModels {

    public Account getAccount(String username, String password) {
        return Account.builder()
                .withId(1L)
                .withUsername(username)
                .withPassword(password)
                .withEnabled(true)
                .withAuthorities(Stream.of(GrantedModels.getGrantedAuthorityImpl()).collect(Collectors.toSet()))
                .build();
    }
}
