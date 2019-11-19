package com.aho.gymgmnt.dao;

import com.aho.gymgmnt.entity.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementDao extends JpaRepository<Abonnement, Integer> {
}
