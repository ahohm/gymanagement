package com.aho.gymgmnt.controller;

import com.aho.gymanagement.entity.Category;
import com.aho.gymanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<Category> getAll(){
        try {
            return new ResponseEntity(categoryService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findOne(@PathVariable int id){
        try {
            return new ResponseEntity(categoryService.findOneById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable int id){
        try {
            categoryService.deleteById(id);
            return  new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("add")
    public ResponseEntity<Category> addNewSubscriber(@RequestBody Category category){
        try {
            return new ResponseEntity(categoryService.add(category),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSubscriber(@PathVariable int id, @RequestBody Category category){
        try{
            return new ResponseEntity(categoryService.update(id, category),HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
