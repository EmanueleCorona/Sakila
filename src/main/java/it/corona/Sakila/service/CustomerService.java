package it.corona.Sakila.service;

import it.corona.Sakila.exception.CustomerAlreadyActiveException;
import it.corona.Sakila.exception.CustomerAlreadyDisabledException;
import it.corona.Sakila.exception.CustomerAlreadySubscribedException;
import it.corona.Sakila.exception.CustomerNotFoundException;
import it.corona.Sakila.model.Customer;
import it.corona.Sakila.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer save(Customer customer) {
        String email = customer.getEmail();

        if (!customerRepository.existsByEmail(email)) {
            customerRepository.save(customer);
        } else {
            throw new CustomerAlreadySubscribedException();
        }

        return customer;
    }

    // Cambiare CascadeType per testare delete
    public Customer delete(Long id) {
        Customer customer = findById(id);
        customerRepository.delete(customer);
        return customer;
    }

    public Customer changeEmail(String email, Long id) {
        Customer customer = findById(id);
        customer.setEmail(email);
        return customerRepository.save(customer);
    }

    public Customer disableCustomer(Long id) {
        Customer customer = findById(id);

        if (customer.getActive()) {
            customer.setActive(false);
            customerRepository.save(customer);
        } else {
            throw new CustomerAlreadyDisabledException();
        }

        return customer;
    }

    public Customer reactivateCustomer(Long id) {
        Customer customer = findById(id);

        if (!customer.getActive()) {
            customer.setActive(true);
            customerRepository.save(customer);
        } else {
            throw new CustomerAlreadyActiveException();
        }

        return customer;
    }

    public List<Customer> getCustomersByCity(String city) {
        return customerRepository.findByCity(city);
    }

    public List<Customer> getCustomersByNumberOfPayments(long numberOfPayments) {
        return customerRepository.findByNumberOfPayments(numberOfPayments);
    }
}
