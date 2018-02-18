package com.boingo.cms.rest;
import com.boingo.cms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.boingo.cms.AppConstants.REST_PARAM_ID;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "{"+REST_PARAM_ID+"}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@PathVariable(REST_PARAM_ID) Integer userId){

        return customerService.getUserById(userId);
    }
}
