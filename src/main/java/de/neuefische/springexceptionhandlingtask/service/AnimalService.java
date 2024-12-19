package de.neuefische.springexceptionhandlingtask.service;

import de.neuefische.springexceptionhandlingtask.exception.NotFoundException;
import de.neuefische.springexceptionhandlingtask.model.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {


    public List<Animal> getAllAnimals() throws Exception{
        throw new Exception("No Animals found");
    }


    public Animal getAnimalSpecies(String species) throws NotFoundException {
        throw new NotFoundException("Animal with species " + species + " not found");
    }

}
