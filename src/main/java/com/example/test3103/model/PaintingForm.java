package com.example.test3103.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PaintingForm {
    //(id, mã tranh, kích thước chiều cao, kích thước chiều rộng, chất liệu, mô tả, giá, danh mục tranh)

    private Long id;
    private String paintingCode;
    private Float height;
    private Float width;
    private String material;
    private String description;
    private String category;
    private MultipartFile img;

    public PaintingForm() {
    }

    public PaintingForm(String paintingCode, Float height, Float width, String material, String description, String category, MultipartFile img) {
        this.paintingCode = paintingCode;
        this.height = height;
        this.width = width;
        this.material = material;
        this.description = description;
        this.category = category;
        this.img = img;
    }

    public PaintingForm(Long id, String paintingCode, Float height, Float width, String material, String description, String category, MultipartFile img) {
        this.id = id;
        this.paintingCode = paintingCode;
        this.height = height;
        this.width = width;
        this.material = material;
        this.description = description;
        this.category = category;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaintingCode() {
        return paintingCode;
    }

    public void setPaintingCode(String paintingCode) {
        this.paintingCode = paintingCode;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
