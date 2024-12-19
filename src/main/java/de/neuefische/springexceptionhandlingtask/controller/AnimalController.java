package de.neuefische.springexceptionhandlingtask.controller;

import de.neuefische.springexceptionhandlingtask.exception.NotFoundException;
import de.neuefische.springexceptionhandlingtask.model.Animal;
import de.neuefische.springexceptionhandlingtask.model.ErrorResponesDTO;
import de.neuefische.springexceptionhandlingtask.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping("/{species}")
    public Animal getAnimalSpecies(@PathVariable String species) throws NotFoundException {
        return service.getAnimalSpecies(species);
    }

    @GetMapping
    public List<Animal> getAllAnimals() throws Exception {
        return service.getAllAnimals();
    }

    // Lokaler Controller Advise
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(NotFoundException e) {
        return e.getMessage() + " (Send from Local)";
    }

}
