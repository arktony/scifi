package com.plant.io.scifi.repository;

import com.plant.io.scifi.entity.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepo extends JpaRepository<ImageModel, Long> {
    List<ImageModel> findByPlantId(Long plantId);
}
