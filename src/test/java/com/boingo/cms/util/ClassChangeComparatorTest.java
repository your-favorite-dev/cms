package com.boingo.cms.util;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClassChangeComparatorTest {
    private ClassChangeComparator classChangeComparator;

    private Address address;
    private Address address1;
    private Address address2;
    private Address address3;

    private Customer customer;
    private Customer customer1;

    @Before
    public void before(){
        classChangeComparator = new ClassChangeComparator();
        address = new Address("123 main st","Apt b3","Cleveland","Ohio","44503");
        address1 = new Address("100 ocean ave","Apt b3","Cleveland","Ohio","44503");
        customer = new Customer("foo","foobar",address);
        customer1 = new Customer("bar","foobar",address1);

        address2 = new Address("15600 Hollywood Blvd","","Los Angeles","CA","90001");
        address3 = new Address("15600 Hollywood Blvd","","Lost Angeles","CA","90002");

    }
    @Test
    public void auditObject() {
        try {
            classChangeComparator.auditObject(customer,customer1).forEach(System.out::println);
            classChangeComparator.auditObject(address2,address3).forEach(System.out::println);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}