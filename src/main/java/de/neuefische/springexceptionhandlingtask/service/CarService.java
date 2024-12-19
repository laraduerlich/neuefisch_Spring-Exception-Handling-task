package de.neuefische.springexceptionhandlingtask.service;

import de.neuefische.springexceptionhandlingtask.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;

@Service
public class CarService {

    public String getAllCars() throws Exception {
        throw new Exception("No Cars found");
    }

    public String getCarBrand(String brand) throws NotFoundException {
        if (!brand.equals("porsche")) {
            throw new NotFoundException("Only 'porsche' allowed");
        }
        return brand;
    }

}

