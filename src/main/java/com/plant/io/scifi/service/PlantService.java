package com.plant.io.scifi.service;


import com.plant.io.scifi.entity.Plant;
import com.plant.io.scifi.repository.PlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {
    @Autowired
    private PlantRepo plantRepo;

    public Plant savePlant(Plant plant) {
        return plantRepo.save(plant);
    }

    public List<Plant> getAllActivePlants() {
        return plantRepo.findAll();
    }

    public Optional<Plant> getPlantById(Long id) {
        return plantRepo.findById(id);
    }
}
