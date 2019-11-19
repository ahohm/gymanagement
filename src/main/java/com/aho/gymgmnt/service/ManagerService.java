package com.aho.gymgmnt.service;

import com.aho.gymgmnt.dao.ManagerDao;
import com.aho.gymgmnt.entity.Category;
import com.aho.gymgmnt.entity.Manager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private ManagerDao managerDao;

    public ManagerService(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }


    public List<Manager> findAll(){
        return managerDao.findAll();
    }

    public Optional<Manager> findOneById(int id){
        return managerDao.findById(id);
    }

    public void deleteById(int id) {
        managerDao.deleteById(id); }

    public Manager add(Manager manager) {
        return managerDao.save(manager);
    }

    public Manager update(int id, Manager manager){
        return managerDao.save(manager);
    }
}
