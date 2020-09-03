package com.netmoor.beseller.service;

import com.netmoor.beseller.model.Account;
import com.netmoor.beseller.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * JpaUserDetailsService.
 *
 * @author Nikolay_Batov
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        log.debug("Try to find Account by userName: {}", username);
        return accountRepository.findOne((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(Account.Fields.username), username))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User name: %s - not found", username)));
    }
}
