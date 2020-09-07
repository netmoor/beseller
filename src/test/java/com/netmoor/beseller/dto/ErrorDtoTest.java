package com.netmoor.beseller.dto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ErrorDtoTest.
 *
 * @author Nikolay_Batov
 */
class ErrorDtoTest {

    private ErrorDto errorDto;

    @BeforeEach
    void setUp() {
        errorDto = new ErrorDto();
    }

    @Test
    void addValidationErrorTest() {
        ErrorDto.ValidationError validation1 = new ErrorDto.ValidationError("field1", "test messag 1", 1L);
        ErrorDto.ValidationError validation2 = new ErrorDto.ValidationError("field2", "test messag 2", 2L);
        ErrorDto.ValidationError validation3 = new ErrorDto.ValidationError("field3", "test messag 3", 3L);
        Map<String, List<ErrorDto.ValidationError>> expected = new HashMap<>();
        expected.put("test_object_1", Stream.of(validation1, validation2).collect(Collectors.toList()));
        expected.put("test_object_2", Stream.of(validation3).collect(Collectors.toList()));


        errorDto = errorDto.toBuilder()
                .errorCode(ErrorCode.VALIDATION_ERROR)
                .message("Test")
                .build();
        errorDto.addValidationError("test_object_1", validation1);
        errorDto.addValidationError("test_object_1", validation2);
        errorDto.addValidationError("test_object_2", validation3);

        assertThat(errorDto, is(
                ErrorDto.builder()
                        .errorCode(ErrorCode.VALIDATION_ERROR)
                        .message("Test")
                        .validationDetails(expected)
                        .build())
        );
    }
}