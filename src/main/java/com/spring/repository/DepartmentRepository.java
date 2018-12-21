package com.spring.repository;

import com.spring.entity.Department;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
}
