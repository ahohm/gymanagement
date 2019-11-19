package com.aho.gymgmnt.dao;

import com.aho.gymgmnt.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDao extends JpaRepository<Manager, Integer> {
}
