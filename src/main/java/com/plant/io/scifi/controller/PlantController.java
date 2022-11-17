package com.plant.io.scifi.controller;

import com.plant.io.scifi.entity.ImageModel;
import com.plant.io.scifi.entity.Plant;
import com.plant.io.scifi.repository.ImageRepo;
import com.plant.io.scifi.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PlantController {

    @Autowired
    private PlantService plantService;

    @Autowired
    private ImageRepo imageRepo;

    @GetMapping(value = {"/addPlant"})
    public String index(Plant plant, Model model){
        return "add_plant";
    }

    @PostMapping(value = {"/addNewPlant"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addNewPlant(
            @ModelAttribute("plant")
            Plant plant,
            BindingResult result,
            Model model,
            @RequestPart("imageFile") MultipartFile[] file
    ) {
        try {
            Set<ImageModel> imageModel = uploadImage(file);
            plant.setPlantImages(imageModel);
            plantService.savePlant(plant);
            model.addAttribute("message","Data Saved Successfully");
            return "index";
        } catch (Exception e) {
            System.out.println("This is Exception "+e.getMessage());
            model.addAttribute("message","Error at server");
            return "index";
        }
    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();
        for (MultipartFile file : multipartFiles) {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }
        return imageModels;
    }

    @GetMapping(value = {"/"})
    public String showAll(Model model){
        Plant plant = new Plant();
        List<Plant> allPlants =plantService.getAllActivePlants();
        model.addAttribute("plants", allPlants);
        return "index";
    }
}
