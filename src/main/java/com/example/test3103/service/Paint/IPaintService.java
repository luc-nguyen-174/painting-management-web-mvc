package com.example.test3103.service.Paint;

import com.example.test3103.model.Category;
import com.example.test3103.model.Painting;
import com.example.test3103.repository.IPaintingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Optional;

@Service
public class IPaintService implements IPaint {
    @Autowired
    private IPaintingRepo paintingRepo;

    @Override
    public Iterable<Painting> findAll() {
        return paintingRepo.findAll();
    }

    @Override
    public Optional<Painting> findById(Long id) {
        return paintingRepo.findById(id);
    }

    @Override
    public void save(Painting painting) {
        paintingRepo.save(painting);
    }

    @Override
    public void remove(Long id) {
        paintingRepo.deleteById(id);
    }

    @Override
    public Iterable<Painting> findAllByCategory(Category category) {
        return paintingRepo.findAllByCategory(category);
    }

    @Override
    public Painting findByPaintingCode(String paintingCode) {
        return paintingRepo.findByPaintingCode(paintingCode);
    }

}
