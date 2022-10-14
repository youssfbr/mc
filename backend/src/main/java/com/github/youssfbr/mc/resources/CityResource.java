package com.github.youssfbr.mc.resources;

import com.github.youssfbr.mc.entities.City;
import com.github.youssfbr.mc.services.interfaces.ICityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityResource {

    private final ICityService cityService;

    public CityResource(ICityService cityService) { this.cityService = cityService; }

    @GetMapping
    public List<City> listAllCities() { return cityService.listAllCities(); }

    @GetMapping("{cityId}")
    public City listCityById(@PathVariable Long cityId) { return cityService.findCityById(cityId); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City insertCity(@RequestBody City city) { return cityService.insertCity(city); }

}
