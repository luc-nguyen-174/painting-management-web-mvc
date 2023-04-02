package com.example.test3103.controller;

import com.example.test3103.model.Category;
import com.example.test3103.service.category.ICategoryService;
import com.example.test3103.service.paint.IPaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPaintService paintService;

    @GetMapping("/create")
    public ModelAndView createCategoryForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("categories", new Category());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView create(@ModelAttribute("categories") Category category) {
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("categories", new Category());
        modelAndView.addObject("message", "New song created successfully. \nBack to list after 3s.");
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView listProvinces() {
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/category/index");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("categories", category);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping(value = "/edit")
    public ModelAndView updateCustomer(@ModelAttribute("categories") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("categories", category);
        modelAndView.addObject("message", "Category updated successfully. \nBack to list after 3s.");
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.remove(id);
        return "redirect:/categories";
    }
}
