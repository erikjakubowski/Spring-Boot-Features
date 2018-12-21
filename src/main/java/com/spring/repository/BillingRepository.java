package com.spring.repository;

import com.spring.entity.Billing;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The reason that we've decided to do this is to get the extra benefits provided by PagingAndSortingRepository.
 * This will add the extra functionality to retrieve entities using the pagination and being able to sort them.
 *
 *
 * The @RepositoryRestResource annotation, while optional,
 * provides us with the ability to have finer control over the exposure of the repository as a web data service.
 */

@RepositoryRestResource
public interface BillingRepository extends PagingAndSortingRepository<Billing, Long> {

}
