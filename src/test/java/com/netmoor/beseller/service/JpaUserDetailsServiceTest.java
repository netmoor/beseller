package com.netmoor.beseller.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.netmoor.beseller.models.AccountsModels;
import com.netmoor.beseller.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

/**
 * JpaUserDetailsServiceTest.
 *
 * @author Nikolay_Batov
 */
@ExtendWith(MockitoExtension.class)
class JpaUserDetailsServiceTest {

    @Mock
    private AccountRepository accountRepository;

    private JpaUserDetailsService service;

    @BeforeEach
    void setUp() {
        service = new JpaUserDetailsService(accountRepository);
    }

    @Test
    void loadUserByUsernameTestException() {
        Mockito.when(accountRepository.findOne(Mockito.any()))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("test"));
    }

    @Test
    void loadUserByUsernameTest() {

        Mockito.when(accountRepository.findOne(Mockito.any()))
                .thenReturn(Optional.ofNullable(AccountsModels.getAccount("test", "test")));
        assertThat(service.loadUserByUsername("test"), is(AccountsModels.getAccount("test", "test")));
    }
}