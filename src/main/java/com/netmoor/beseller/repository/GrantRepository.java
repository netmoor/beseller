package com.netmoor.beseller.repository;

import com.netmoor.beseller.model.GrantedAuthorityImpl;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * GrantRepository.
 *
 * @author Nikolay_Batov
 */
@Repository
public interface GrantRepository extends PagingAndSortingRepository<GrantedAuthorityImpl, Long>, JpaSpecificationExecutor<GrantedAuthorityImpl> {
}
