package com.example.test3103.model;

import com.example.test3103.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public class PaintingForm {
    private Long id;
    private String name;
    private Long height;
    private Long width;
    private String material;
    private String description;
    private Long price;
    private MultipartFile image;
    private Category category;

    public PaintingForm() {
    }

    public PaintingForm(String name, Long height, Long width, String material, String description, Long price, MultipartFile image, Category category) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.material = material;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}