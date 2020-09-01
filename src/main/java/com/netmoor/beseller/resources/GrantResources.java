package com.netmoor.beseller.resources;

import com.netmoor.beseller.dto.GrantDto;
import com.netmoor.beseller.mappers.GrantedAuthorityImplMapper;
import com.netmoor.beseller.service.GrantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * GrantResources.
 *
 * @author Nikolay_Batov
 */
@RestController
@RequestMapping("/admin/grant")
@RequiredArgsConstructor
public class GrantResources {

    private final GrantService service;
    private final GrantedAuthorityImplMapper mapper;

    @GetMapping("/all")
    public List<GrantDto> getAllGrants() {
        return service.getAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }
}
