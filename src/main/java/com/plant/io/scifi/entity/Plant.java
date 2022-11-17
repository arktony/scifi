package com.plant.io.scifi.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "plant")
public class Plant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scientificName;
    private String englishName;
    private String localName;
    private String narration;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "plant_images",
            joinColumns = {
            @JoinColumn(name ="plant_id")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "image_id")
            }
    )
    private Set<ImageModel> plantImages;

    public Set<ImageModel> getPlantImages() {
        return plantImages;
    }

    public void setPlantImages(Set<ImageModel> plantImages) {
        this.plantImages = plantImages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }
}
