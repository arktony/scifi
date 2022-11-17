package com.plant.io.scifi.dao;

public class PlantDao {

    private Long id;
    private String scientificName;
    private String englishName;
    private String localName;
    private String narration;

    public PlantDao() {
    }

    public PlantDao(Long id, String scientificName, String englishName, String localName, String narration) {
        this.id = id;
        this.scientificName = scientificName;
        this.englishName = englishName;
        this.localName = localName;
        this.narration = narration;
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
