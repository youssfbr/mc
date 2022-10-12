package com.github.youssfbr.mc.services.interfaces;

import com.github.youssfbr.mc.entities.City;

import java.util.List;

public interface ICityService {

    List<City> listAllCities();
    City findCityById(Long cityId);
    City insertCity(City city);

}
