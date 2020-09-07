package com.netmoor.beseller.dto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * GrantDto.
 *
 * @author Nikolay_Batov
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Tag(name = "GrantDto", description = "Granted permissions")
public class GrantDto {

    @NotNull
    @Min(0) @Max(Long.MAX_VALUE)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String authority;
}
