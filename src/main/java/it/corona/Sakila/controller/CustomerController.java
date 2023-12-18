package it.corona.Sakila.controller;

import it.corona.Sakila.model.Customer;
import it.corona.Sakila.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping(value = "/sign-up")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @DeleteMapping(value = "/{id}/delete")
    public Customer delete(@PathVariable Long id) {
        return customerService.delete(id);
    }

    @PatchMapping(value = "/{id}/change-email")
    public Customer changeEmail(@RequestBody String email, @PathVariable Long id) {
        return customerService.changeEmail(email, id);
    }

    @PatchMapping(value = "/{id}/disable")
    public Customer disableCustomer(@PathVariable Long id) {
        return customerService.disableCustomer(id);
    }

    @PatchMapping(value = "/{id}/reactivate-customer")
    public Customer reactiveCustomer(@PathVariable Long id) {
        return customerService.reactivateCustomer(id);
    }

    @GetMapping(value = "/find-by-location/{city}")
    public List<Customer> getCustomersByCity(@PathVariable String city) {
        return customerService.getCustomersByCity(city);
    }

    @GetMapping(value = "/manage/user-of-the-year")
    public List<Customer> getCustomersByNumberOfPayments(@PathVariable long numberOfPayments) {
        return customerService.getCustomersByNumberOfPayments(numberOfPayments);
    }
}
