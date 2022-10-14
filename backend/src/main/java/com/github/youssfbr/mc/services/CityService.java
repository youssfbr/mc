package com.github.youssfbr.mc.services;

import com.github.youssfbr.mc.entities.City;
import com.github.youssfbr.mc.repositories.ICityRepository;
import com.github.youssfbr.mc.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.mc.services.interfaces.ICityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService implements ICityService {

    private final ICityRepository cityRepository;

    public CityService(ICityRepository cityRepository) { this.cityRepository = cityRepository; }

    @Override
    @Transactional(readOnly = true)
    public List<City> listAllCities() { return cityRepository.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public City findCityById(Long cityId) {
        return cityRepository
                .findById(cityId)
                .orElseThrow (() -> new ResourceNotFoundException("Cidade não encontrada com id " + cityId));
    }

    @Override
    @Transactional
    public City insertCity(City city) {
        return cityRepository.save(city);
    }

}
