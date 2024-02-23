package tz.proj.Services;

import tz.proj.DTO.CustomerDTO;
import tz.proj.Models.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findAllCustomers();
    Customer saveCustomer(Customer customer);
}
