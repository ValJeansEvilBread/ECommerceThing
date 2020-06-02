package com.tts.ECommerceThing.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.ECommerceThing.model.Category;
import com.tts.ECommerceThing.model.Product;
import com.tts.ECommerceThing.model.User;
import com.tts.ECommerceThing.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(long id) {
        return productRepository.findById(id);
    }

    public List<String> findDistinctBrands() {
        return productRepository.findDistinctBrands();
    }

    public List<String> findDistinctCategories() {
        return productRepository.findDistinctCategories();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findByBrandAndOrCategory(String brand, String category) {
        if(category == null && brand == null)
            return productRepository.findAll();
        else if(category == null)
            return productRepository.findByBrand(brand);
        else if(brand == null)
            return  productRepository.findByCategory(category);
        else
            return productRepository.findByBrandAndCategory(brand, category);
    }
}