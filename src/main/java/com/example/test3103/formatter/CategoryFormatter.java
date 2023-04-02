package com.example.test3103.formatter;

import com.example.test3103.model.Category;
import com.example.test3103.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class CategoryFormatter implements Formatter<Category> {
    private ICategoryService categoryService;

    @Autowired
    public CategoryFormatter(ICategoryService category) {
        this.categoryService = category;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> provinceOptional = categoryService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " +object.getCategory() + "]";
    }
}
