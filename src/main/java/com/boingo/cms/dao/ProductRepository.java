package com.boingo.cms.dao;

import com.boingo.cms.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
}
