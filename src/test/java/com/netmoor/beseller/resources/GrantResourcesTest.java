package com.netmoor.beseller.resources;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.netmoor.beseller.dto.GrantDto;
import com.netmoor.beseller.mappers.GrantedAuthorityImplMapperImpl;
import com.netmoor.beseller.model.GrantedAuthorityImpl;
import com.netmoor.beseller.service.GrantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

/**
 * GrantResourcesTest.
 *
 * @author Nikolay_Batov
 */
@ExtendWith(MockitoExtension.class)
class GrantResourcesTest {

    @Mock
    private GrantService service;
    private GrantResources resources;

    @BeforeEach
    void setUp() {
        resources = new GrantResources(service, new GrantedAuthorityImplMapperImpl());
    }

    @Test
    public void getAllGrantsTest() {
        Mockito.when(service.getAll()).thenReturn(Stream.of(
                GrantedAuthorityImpl.builder()
                        .id(1L)
                        .authority("ADMIN")
                        .build(),
                GrantedAuthorityImpl.builder()
                        .id(2L)
                        .authority("USER")
                        .build()
        ).collect(toList()));

        assertThat(
                resources.getAllGrants(),
                is(Stream.of(
                        GrantDto.builder()
                                .id(1L)
                                .authority("ADMIN")
                                .build(),
                        GrantDto.builder()
                                .id(2L)
                                .authority("USER")
                                .build()
                        ).collect(toList())
                )
        );
    }
}