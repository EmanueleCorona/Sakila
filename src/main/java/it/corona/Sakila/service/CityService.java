package it.corona.Sakila.service;

import it.corona.Sakila.exception.CityNotFoundException;
import it.corona.Sakila.model.City;
import it.corona.Sakila.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(CityNotFoundException::new);
    }
}
