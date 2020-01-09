package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CarsRepository repository;
    @Override
    public void run(String ... strings) throws Exception {
        Cars cars;
        cars = new Cars("2019", "Honda", "Pilot");
        repository.save(cars);
        cars = new Cars("2017", "Toyota", "Camry");
        repository.save(cars);
        cars = new Cars("1999", "Nissan", "Altima");
        repository.save(cars);
    }
}
