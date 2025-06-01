package com.backend.myTicket.controller;

import com.backend.myTicket.entity.Category;
import com.backend.myTicket.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name="Category REST API Endpoints", description = "Operations related to categories")
public class CategoryRestController {
    private CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService theCategoryService) {
        categoryService = theCategoryService;
    }
    @Operation(summary="Get All Categories", description = "Get all available categories")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<Category> getAllCategories() {
        return categoryService.findAllCategories();
    }
}
