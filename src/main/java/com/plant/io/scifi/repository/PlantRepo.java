package com.plant.io.scifi.repository;


import com.plant.io.scifi.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepo extends JpaRepository<Plant,Long> {
}
