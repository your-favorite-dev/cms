package com.boingo.cms.dao;

import com.boingo.cms.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("customerRepo")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
}
