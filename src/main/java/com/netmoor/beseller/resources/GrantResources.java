package com.netmoor.beseller.resources;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.netmoor.beseller.dto.CreateGrantDto;
import com.netmoor.beseller.dto.ErrorDto;
import com.netmoor.beseller.dto.GrantDto;
import com.netmoor.beseller.mappers.GrantedAuthorityImplMapper;
import com.netmoor.beseller.service.GrantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GrantResources.
 *
 * @author Nikolay_Batov
 */
@Slf4j
@RestController
@RequestMapping("/admin/grant")
@RequiredArgsConstructor
@Tag(name = "Grants Resources", description = "Resources granted permissions")
public class GrantResources {

    private final GrantService service;
    private final GrantedAuthorityImplMapper mapper;

    @GetMapping("/all")
    @Operation(summary = "Get all grants", security = @SecurityRequirement(name = "JSESSIONID"))
    public List<GrantDto> getAllGrants() {
        return service.getAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    @PostMapping("/create")
    @Operation(summary = "Create grant", security = @SecurityRequirement(name = "JSESSIONID"))
    public GrantDto createGrant(@Validated @ParameterObject CreateGrantDto createGrantDto) {
        log.debug("Start create grant: {}", createGrantDto);
        return mapper.mapToDto(service.saveGrant(mapper.mapToModel(createGrantDto)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get grant by id", security = @SecurityRequirement(name = "JSESSIONID"))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the grant",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = GrantDto.class))}),
            @ApiResponse(responseCode = "404", description = "Grant not found",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorDto.class))})
    })
    @Parameters(value = {
            @Parameter(name = "id", example = "1", description = "Id of grand"),
            @Parameter(in = ParameterIn.COOKIE, name = "locale", example = "ru_RU", description = "Locale, default is \"en\"")
    })
    public GrantDto getById(@PathVariable @Valid @PositiveOrZero Long id) {
        return mapper.mapToDto(service.findById(id));
    }
}
