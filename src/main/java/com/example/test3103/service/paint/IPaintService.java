package com.example.test3103.service.paint;

import com.example.test3103.model.Category;
import com.example.test3103.model.Painting;
import com.example.test3103.service.IGen;

public interface IPaintService extends IGen<Painting> {
    Iterable<Painting> findAllByCategory(Category category);
    Painting findByName(String name);
}
