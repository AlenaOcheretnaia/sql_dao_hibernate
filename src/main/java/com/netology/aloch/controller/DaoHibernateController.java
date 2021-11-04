package com.netology.aloch.controller;

import com.netology.aloch.repository.DaoHibernateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaoHibernateController {

    @Autowired
    DaoHibernateRepository daoHibernateRepository;

    @GetMapping("/")
    public String hello(){
        return "Hello from DaoLayerHibernate";
    }

    @GetMapping("/persons/by-city")
    public String getOrders(@RequestParam String city) {
        var result = daoHibernateRepository.getPersonsByCity(city);
        return ("Person(s) with city = " + city + " is/are:" + "<br>" + result);
    }
}
