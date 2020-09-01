package com.netmoor.beseller.repository.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

/**
 * PrepareSpecifications.
 *
 * @author Nikolay_Batov
 */
@UtilityClass
public class PrepareSpecifications {

    public <T> Specification<T> equalField(Object value, String fieldName) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(fieldName), value);
    }

    public <T> Specification<T> notEqual(Object value, String fieldName) {
        return (root, query, builder) -> builder.equal(root.get(fieldName), value).not();
    }
}
