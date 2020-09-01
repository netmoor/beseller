package com.netmoor.beseller.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.netmoor.beseller.model.GrantedAuthorityImpl;
import com.netmoor.beseller.models.GrantedModels;
import com.netmoor.beseller.repository.GrantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * GrantServiceTest.
 *
 * @author Nikolay_Batov
 */
@ExtendWith(MockitoExtension.class)
class GrantServiceTest {

    @Mock
    private GrantRepository repository;

    private GrantService service;

    @BeforeEach
    void setUp() {
        service = new GrantService(repository);
    }

    @Test
    void getAllTest() {
        List<GrantedAuthorityImpl> user = Stream.of(GrantedModels.getGrantedAuthorityImpl(), new GrantedAuthorityImpl(2L, "USER"))
                .collect(Collectors.toList());
        Mockito.when(repository.findAll()).thenReturn(user);
        assertThat(service.getAll(), is(user));
    }
}