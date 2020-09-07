package com.netmoor.beseller.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * CreateGrantDto.
 *
 * @author Nikolay_Batov
 */
@Data
public class CreateGrantDto {

    @NotBlank
    @Size(min = 3, max = 50)
    @Parameter(in = ParameterIn.QUERY, description = "Name of grant", example = "ADMIN")
    private String grant;
}
