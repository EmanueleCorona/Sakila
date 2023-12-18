package it.corona.Sakila.service;

import it.corona.Sakila.exception.AddressNotFoundException;
import it.corona.Sakila.model.Address;
import it.corona.Sakila.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(AddressNotFoundException::new);
    }
}
