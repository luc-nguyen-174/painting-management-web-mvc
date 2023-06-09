package com.example.test3103.controller;

import com.example.test3103.model.Category;
import com.example.test3103.model.Painting;
import com.example.test3103.model.PaintingForm;
import com.example.test3103.service.category.ICategoryService;
import com.example.test3103.service.paint.IPaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/paintings")
public class PaintingController {

    @Value("${file-upload}")
    private String fileUpload;


    @Autowired
    private IPaintService paintingService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("")
    public ModelAndView index() {
        Iterable<Painting> paintings = paintingService.findAll();
        ModelAndView modelAndView = new ModelAndView("/painting/index");
        modelAndView.addObject("paintings", paintings);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateFrom() {
        ModelAndView modelAndView = new ModelAndView("/painting/create");
        modelAndView.addObject("paintings", new PaintingForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView createNewPainting(@ModelAttribute PaintingForm paintingFrom) {
        // Save image
        MultipartFile multipartFile = paintingFrom.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(paintingFrom.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Save painting
        Painting painting = new Painting(paintingFrom.getName(), paintingFrom.getHeight(), paintingFrom.getWidth(),
                paintingFrom.getMaterial(), paintingFrom.getDescription(), paintingFrom.getPrice(), fileName,
                paintingFrom.getCategory());
        paintingService.save(painting);
        // Return success message
        ModelAndView modelAndView = new ModelAndView("/painting/create");
        modelAndView.addObject("paintings", new Painting());
        modelAndView.addObject("message", "Create a new painting successfully. \n Back to list after 3s");
        return modelAndView;
    }


    //remove painting
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        paintingService.remove(id);
        return "redirect:/paintings";
    }


    //edit information
    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateFrom(@PathVariable Long id) {
        Optional<Painting> painting = paintingService.findById(id);
        if (painting.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/painting/edit");
            modelAndView.addObject("paintings", painting.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute Painting painting) {
        paintingService.save(painting);
        ModelAndView modelAndView = new ModelAndView("/painting/edit");
        modelAndView.addObject("paintings", painting);
        modelAndView.addObject("message", "Painting updated successfully. \nBack to list after 3s.");
        return modelAndView;
    }
}