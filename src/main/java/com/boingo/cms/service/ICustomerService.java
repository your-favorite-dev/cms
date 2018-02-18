package com.boingo.cms.service;

import org.springframework.http.ResponseEntity;

public interface ICustomerService {
    ResponseEntity<?> getUserById(int id);
}
