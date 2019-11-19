package com.aho.gymgmnt.controller;

import com.aho.gymgmnt.entity.Manager;
import com.aho.gymgmnt.service.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public ResponseEntity<Manager> getAll(){
        try {
            return new ResponseEntity(managerService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Manager>> findOne(@PathVariable int id){
        try {
            return new ResponseEntity(managerService.findOneById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable int id){
        try {
            managerService.deleteById(id);
            return  new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("add")
    public ResponseEntity<Manager> addNewSubscriber(@RequestBody Manager category){
        try {
            return new ResponseEntity(managerService.add(category),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSubscriber(@PathVariable int id, @RequestBody Manager category){
        try{
            return new ResponseEntity(managerService.update(id, category),HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
