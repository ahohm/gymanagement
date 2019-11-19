package com.aho.gymgmnt.controller;

import com.aho.gymgmnt.entity.Abonnement;
import com.aho.gymgmnt.service.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/abonnement")
public class AbonnementController {

    private AbonnementService abonnementService;

    @Autowired
    public AbonnementController(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }


    @GetMapping
    public ResponseEntity<Abonnement> getAll(){
        try {
            return new ResponseEntity(abonnementService.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Abonnement>> findOne(@PathVariable int id){
        try {
            return new ResponseEntity(abonnementService.findOneById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable int id){
        try {
            abonnementService.deleteById(id);
            return  new ResponseEntity(HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("add/")
    public ResponseEntity<Abonnement> addNewSubscriber(@RequestParam(value = "abonneId") int abonneId,
                                                       @RequestParam(value = "categoryId") int categoryId,
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        try {
            System.out.println("check point");
            return new ResponseEntity(abonnementService.add(abonneId, categoryId, startDate,
                    endDate),HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSubscriber(@PathVariable int id, @RequestBody Abonnement category){
        try{
            return new ResponseEntity(abonnementService.update(id, category),HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
