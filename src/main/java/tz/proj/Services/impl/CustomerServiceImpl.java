package tz.proj.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tz.proj.DTO.CustomerDTO;
import tz.proj.Models.Customer;
import tz.proj.Repository.CustomerRepository;
import tz.proj.Services.CustomerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> mapToCustomerDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    private CustomerDTO mapToCustomerDTO(Customer customer){
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(customer.getUserId())
                .surname(customer.getSurname())
                .name(customer.getName())
                .secondName(customer.getSecondName())
                .familyState(customer.getFamilyState())
                .phoneNumber(customer.getPhoneNumber())
                .creditSum(customer.getCreditSum())
                .build();

        return customerDTO;
    }
}
