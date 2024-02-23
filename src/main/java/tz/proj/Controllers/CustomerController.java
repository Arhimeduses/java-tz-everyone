package tz.proj.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tz.proj.DTO.CustomerDTO;
import tz.proj.Models.Customer;
import tz.proj.Services.CustomerService;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/Customers")
    public String listCustomers(Model model){
        List<CustomerDTO> customers = customerService.findAllCustomers();
        model.addAttribute("customers", customers);
        return "customers-list";
    }

    @GetMapping("/newCredit/personalData")
    public String createCreditForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create-credit";
    }

    @PostMapping("/newCredit/personalData")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/";
    }
}
