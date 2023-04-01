package com.example.test3103.service.Paint;

import com.example.test3103.model.Category;
import com.example.test3103.model.Painting;
import com.example.test3103.service.IGen;

import java.awt.*;

public interface IPaint extends IGen<Painting> {
    Iterable<Painting> findAllByCategory(Category category);
    Painting findByPaintingCode(String paintingCode);
}
