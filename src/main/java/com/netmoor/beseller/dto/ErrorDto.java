package com.netmoor.beseller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ErrorDto.
 *
 * @author Nikolay_Batov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ErrorDto {

    @NotNull
    private ErrorCode errorCode;

    @NotBlank
    private String message;

    @Singular
    private Map<String, List<ValidationError>> validationDetails;

    public ErrorDto(@NotNull ErrorCode errorCode, @NotBlank String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public void addValidationError(String objectName, ValidationError validationError) {
        if (CollectionUtils.isEmpty(validationDetails)) {
            this.validationDetails = new HashMap<>();
            this.validationDetails.put(objectName, Stream.of(validationError).collect(Collectors.toList()));
        } else {
            this.validationDetails.compute(
                    objectName,
                    (key, value) -> Optional.ofNullable(value).map(
                            val -> {
                                val.add(validationError);
                                return val;
                            }).orElse(Stream.of(validationError).collect(Collectors.toList())));
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ValidationError {

        private String fieldName;

        private String message;

        private Object rejectedValue;
    }
}
