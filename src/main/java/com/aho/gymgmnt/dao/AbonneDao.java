package com.aho.gymgmnt.dao;

import com.aho.gymgmnt.entity.Abonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneDao  extends JpaRepository<Abonne, Integer> {

    Abonne findAbonneByCinEquals(String cin);

}
