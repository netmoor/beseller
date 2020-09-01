package com.netmoor.beseller.mappers;

import com.netmoor.beseller.dto.GrantDto;
import com.netmoor.beseller.model.GrantedAuthorityImpl;
import org.mapstruct.Mapper;

/**
 * GrantedAuthorityImplMapper.
 *
 * @author Nikolay_Batov
 */
@Mapper(componentModel = "spring")
public interface GrantedAuthorityImplMapper {

    GrantedAuthorityImpl mapToModel(GrantDto grantDto);

    GrantDto mapToDto(GrantedAuthorityImpl grantedAuthority);
}
