package com.aho.gymgmnt.service;

import com.aho.gymgmnt.dao.AbonneDao;
import com.aho.gymgmnt.entity.Abonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbonneService {

    private AbonneDao abonneDao;

    @Autowired
    public AbonneService(AbonneDao abonneDao) {
        this.abonneDao = abonneDao;
    }

    public List<Abonne> findAll(){
        return (List<Abonne>) abonneDao.findAll();
    }

    public Optional<Abonne> findOneById(int id){
        return abonneDao.findById(id);
    }

    public void deleteById(int id) {
        abonneDao.deleteById(id); }

    public Abonne add(Abonne abonne) {
        return abonneDao.save(abonne);
    }

    public  Abonne update(int id, Abonne abonne){
        return abonneDao.save(abonne);
    }

    public Abonne findByCin(String cin){
        return abonneDao.findAbonneByCinEquals(cin);
    }
}

