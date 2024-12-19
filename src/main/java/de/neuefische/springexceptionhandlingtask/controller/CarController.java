package de.neuefische.springexceptionhandlingtask.controller;

import de.neuefische.springexceptionhandlingtask.exception.NotFoundException;
import de.neuefische.springexceptionhandlingtask.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    // Lokaler Controller Advise
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handelCarNotFoundException(NotFoundException e) {
        return e.getMessage() + "(Send from Lokal)";
    }

    @GetMapping("{brand}")
    public String getCarBrand(@PathVariable String brand) throws Exception {
       return service.getCarBrand(brand);
    }

    @GetMapping
    public String getAllCars() throws Exception {
        return service.getAllCars();
    }
}
