package com.netmoor.beseller.repository;

import com.netmoor.beseller.model.Account;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * AccountRepository.
 *
 * @author Nikolay_Batov
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Long>, JpaSpecificationExecutor<Account> {
}
