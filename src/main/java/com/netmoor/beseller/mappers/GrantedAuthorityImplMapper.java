package com.netmoor.beseller.mappers;

import com.netmoor.beseller.dto.CreateGrantDto;
import com.netmoor.beseller.dto.GrantDto;
import com.netmoor.beseller.model.GrantedAuthorityImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * GrantedAuthorityImplMapper.
 *
 * @author Nikolay_Batov
 */
@Mapper(componentModel = "spring")
public interface GrantedAuthorityImplMapper {

    
    GrantedAuthorityImpl mapToModel(GrantDto grantDto);

    @Mapping(target = "authority", source = "grant")
    GrantedAuthorityImpl mapToModel(CreateGrantDto grantDto);

    @Mapping(target = "authority", expression = "java(grantedAuthority.getAuthority().substring(5))")
    GrantDto mapToDto(GrantedAuthorityImpl grantedAuthority);
}
