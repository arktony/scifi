package com.plant.io.scifi.service;

import com.plant.io.scifi.entity.ImageModel;
import com.plant.io.scifi.entity.Plant;
import com.plant.io.scifi.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepo imageRepo;

    public List<ImageModel> getAllPlantsImages(Long plantId) {
        return imageRepo.findByPlantId(plantId);
    }
}
