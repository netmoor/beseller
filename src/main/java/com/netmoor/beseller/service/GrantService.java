package com.netmoor.beseller.service;

import com.netmoor.beseller.model.GrantedAuthorityImpl;
import com.netmoor.beseller.repository.GrantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * GrantService.
 *
 * @author Nikolay_Batov
 */
@Service
@RequiredArgsConstructor
public class GrantService {

    private final GrantRepository repository;

    public List<GrantedAuthorityImpl> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
