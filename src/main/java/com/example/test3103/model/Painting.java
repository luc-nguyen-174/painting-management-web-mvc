package com.example.test3103.model;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
@Table
public class Painting {
    //(id, mã tranh, kích thước chiều cao, kích thước chiều rộng, chất liệu, mô tả, giá, danh mục tranh)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paintingCode;
    private Float height;
    private Float width;
    private String material;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    private String img;

    public Painting() {
    }

    public Painting(String paintingCode, Float height, Float width, String material, String description, String img) {
        this.paintingCode = paintingCode;
        this.height = height;
        this.width = width;
        this.material = material;
        this.description = description;
        this.img = img;
    }

    public Painting(String paintingCode, Float height, Float width, String material, String description, Category category, String img) {
        this.paintingCode = paintingCode;
        this.height = height;
        this.width = width;
        this.material = material;
        this.description = description;
        this.category = category;
        this.img = img;
    }

    public Painting(Long id, String paintingCode, Float height, Float width, String material, String description, Category category, String img) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
