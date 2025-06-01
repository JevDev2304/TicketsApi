package com.backend.myTicket.service;

import com.backend.myTicket.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    List<Category> findAllCategories();
}
