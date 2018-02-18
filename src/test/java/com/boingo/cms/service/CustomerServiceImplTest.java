package com.boingo.cms.service;


import com.boingo.cms.dao.CustomerRepository;
import com.boingo.cms.dto.CustomerDTO;
import com.boingo.cms.entity.*;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository mockCustomerRepo;

    @Mock
    private CustomerAddress mockCustomerAddress;

    @Mock
    private CustomerAddress mockCustomerAddress2;

    @Mock
    private CustomerProduct mockCustomerProduct;

    @Mock
    private CustomerProduct mockCustomerProduct2;

    @Mock
    private CustomerProduct mockCustomerProduct3;

    @Mock
    private Address mockAddress;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private Customer mockCustomer;

    @Mock
    private Product mockProduct;

    @Mock
    private Product mockProduct2;

    @Mock
    private Product mockProduct3;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mockAddress.getCity()).thenReturn("New York");
        when(mockAddress.getCountry()).thenReturn("US");
        List<CustomerAddress> customerAddressList = Lists.newArrayListWithCapacity(2);
        customerAddressList.add(mockCustomerAddress);
        customerAddressList.add(mockCustomerAddress2);
        when(mockAddress.getCustomers()).thenReturn(customerAddressList);
        when(mockAddress.getId()).thenReturn(1);
        when(mockAddress.getPostalCode()).thenReturn("10029");
        when(mockAddress.getState()).thenReturn("NY");
        when(mockAddress.getStreetAddress()).thenReturn("100 Centre St");

        when(mockProduct.getId()).thenReturn(1);
        when(mockProduct.getName()).thenReturn("Widget1");

        when(mockCustomerProduct.getPurchaseDate()).thenReturn(new Date());
        when(mockCustomerProduct.getCustomer()).thenReturn(mockCustomer);
        when(mockCustomerProduct.getProduct()).thenReturn(mockProduct);

        when(mockProduct.getId()).thenReturn(2);
        when(mockProduct.getName()).thenReturn("Widget3");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR,48);
        when(mockCustomerProduct2.getPurchaseDate()).thenReturn(cal.getTime());
        when(mockCustomerProduct2.getCustomer()).thenReturn(mockCustomer);
        when(mockCustomerProduct2.getProduct()).thenReturn(mockProduct2);

        when(mockProduct.getId()).thenReturn(3);
        when(mockProduct.getName()).thenReturn("Widget3");

        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.MONTH,2);

        when(mockCustomerProduct3.getPurchaseDate()).thenReturn(cal.getTime());
        when(mockCustomerProduct3.getCustomer()).thenReturn(mockCustomer);
        when(mockCustomerProduct3.getProduct()).thenReturn(mockProduct3);

        List<CustomerProduct> mockCustomerProductList = Lists.newArrayListWithExpectedSize(3);
        mockCustomerProductList.add(mockCustomerProduct);
        mockCustomerProductList.add(mockCustomerProduct2);
        mockCustomerProductList.add(mockCustomerProduct3);
        when(mockCustomer.getFirstName()).thenReturn("John");
        when(mockCustomer.getLastName()).thenReturn("Brown");
        when(mockCustomer.getAddresses()).thenReturn(customerAddressList);
        when(mockCustomer.getProducts()).thenReturn(mockCustomerProductList);

        when(mockCustomerRepo.findOne(1)).thenReturn(mockCustomer);

    }

    @Test
    public void getUserById() {
        ResponseEntity responseEntity = customerService.getUserById(1);
        assertEquals(responseEntity.getStatusCode(), ResponseEntity.ok().build().getStatusCode());
    }

    @Test
    public void createCustomerDTO() {
        CustomerDTO customerDTO = customerService.createCustomerDTO(mockCustomer);
        assertNotNull(customerDTO);
        assertEquals(customerDTO.getFirstName(), mockCustomer.getFirstName());
    }
}