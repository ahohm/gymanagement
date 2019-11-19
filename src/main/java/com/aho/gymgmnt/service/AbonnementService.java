package com.aho.gymgmnt.service;

import com.aho.gymgmnt.dao.AbonneDao;
import com.aho.gymgmnt.dao.AbonnementDao;
import com.aho.gymgmnt.dao.CategoryDao;
import com.aho.gymgmnt.entity.Abonne;
import com.aho.gymgmnt.entity.Abonnement;
import com.aho.gymgmnt.entity.Category;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AbonnementService {


    private AbonneDao abonneDao;
    private CategoryDao categoryDao;

    private AbonnementDao abonnementDao;

    @Autowired
    public AbonnementService(AbonnementDao abonnementDao) {
        this.abonnementDao = abonnementDao;
    }

    @Autowired
    public void setAbonneDao(AbonneDao abonneDao) {
        this.abonneDao = abonneDao;
    }

    @Autowired
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Abonnement> findAll(){
        return (List<Abonnement>) abonnementDao.findAll();
    }

    public Optional<Abonnement> findOneById(int id){
        return abonnementDao.findById(id);
    }

    public void deleteById(int id) {
        abonnementDao.deleteById(id); }

    public Abonnement add(int abonneId, int categoryId, LocalDate startDate, LocalDate endDate) {
        Optional<Abonne> abonne = abonneDao.findById(abonneId);
        Optional<Category> category = categoryDao.findById(categoryId);

        Abonnement abonnement = new Abonnement(abonne.get(), category.get(), startDate,endDate);
        return abonnementDao.save(abonnement);
    }

    public  Abonnement update(int id, Abonnement abonnement){
        return abonnementDao.save(abonnement);
    }

}
