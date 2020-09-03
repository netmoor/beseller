package com.netmoor.beseller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GrantDto.
 *
 * @author Nikolay_Batov
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class GrantDto {
    private Long id;
    private String authority;
}
