package com.boingo.cms.service;

import com.boingo.cms.dao.CustomerRepository;
import com.boingo.cms.dto.AddressDTO;
import com.boingo.cms.dto.CustomerDTO;
import com.boingo.cms.dto.ProductDTO;
import com.boingo.cms.entity.AddressType;
import com.boingo.cms.entity.Customer;
import com.boingo.cms.entity.CustomerAddress;
import com.boingo.cms.entity.CustomerProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.boingo.cms.AppConstants.EXPIRED_DAYS;
@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    @Transactional
    public ResponseEntity<?> getUserById(int id) {
        Customer customer = customerRepo.findOne(id);
        if(customerIsPresent(customer)){
            CustomerDTO customerDTO = createCustomerDTO(customer);
            return ResponseEntity.ok().body(customerDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    protected CustomerDTO createCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        List<ProductDTO> productDTOList = customer.getProducts()
                .stream()
                .filter(this::isNotExpired)
                .map(this::getProductDTO)
                .collect(Collectors.toList());

        customerDTO.setProducts(productDTOList);
        customerDTO.setId(customer.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        setCustomerDTOAddresses(customerDTO, customer);

        return customerDTO;
    }

    private void setCustomerDTOAddresses(CustomerDTO customerDTO, Customer customer) {
        if(!customer.getAddresses().isEmpty()){
            for (CustomerAddress customerAddress:customer.getAddresses()){
                if(AddressType.BILLING.equals(customerAddress.getType())){
                    AddressDTO addressDTO = new AddressDTO(customerAddress.getAddress());
                    customerDTO.setBillingAddress(addressDTO);
                }else if(AddressType.MAILING.equals(customerAddress.getType())){
                    AddressDTO addressDTO = new AddressDTO(customerAddress.getAddress());
                    customerDTO.setMailingAddress(addressDTO);
                }
            }
        }
    }

    private <R extends ProductDTO> ProductDTO getProductDTO(CustomerProduct cp) {
       return new ProductDTO(cp);
    }

    private boolean isNotExpired(CustomerProduct cp) {
        Date purchaseDate = cp.getPurchaseDate();
        LocalDateTime localPurchaseDate = LocalDateTime.ofInstant(
                purchaseDate.toInstant(), ZoneId.systemDefault());
        localPurchaseDate = localPurchaseDate.plusDays(EXPIRED_DAYS);
        LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
        return localPurchaseDate.isAfter(now);
    }

    private boolean customerIsPresent(Customer customer) {
        return null !=customer;
    }
}
