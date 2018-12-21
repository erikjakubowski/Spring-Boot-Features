package com.spring.repository;

import com.spring.entity.Supplies;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SuppliesRepository extends PagingAndSortingRepository<Supplies, Long> {
}
