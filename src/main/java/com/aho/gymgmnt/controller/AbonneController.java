package com.aho.gymgmnt.controller;

import com.aho.gymgmnt.entity.Abonne;
import com.aho.gymgmnt.service.AbonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/abonne")
public class AbonneController {

    private AbonneService abonneService;

    @Autowired
    public AbonneController(AbonneService abonneService) {
        this.abonneService = abonneService;
    }

    @GetMapping
    public ResponseEntity<Abonne> getAll(){
        try {
            return new ResponseEntity(abonneService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Abonne>> findOne(@PathVariable int id){
        try {
            return new ResponseEntity(abonneService.findOneById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable int id){
        try {
            abonneService.deleteById(id);
            return  new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("add")
    public ResponseEntity<Abonne> addNewSubscriber(@RequestBody Abonne abonne){
        try {
            return new ResponseEntity(abonneService.add(abonne),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSubscriber(@PathVariable int id, @RequestBody Abonne abonne){
        try{
            return new ResponseEntity(abonneService.update(id, abonne),HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByCin/{cin}")
    public ResponseEntity<Abonne> findCin(@PathVariable String cin){
        return new ResponseEntity(abonneService.findByCin(cin), HttpStatus.OK);
    }
}
