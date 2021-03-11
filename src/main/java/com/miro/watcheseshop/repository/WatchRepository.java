package com.miro.watcheseshop.repository;

import com.miro.watcheseshop.entity.Watch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class WatchRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Watch> getAll() {
        return em.createQuery("SELECT w FROM Watch w",Watch.class).getResultList();
    }

    public Watch insert(Watch watch){
        this.em.persist(watch);
        return watch;
    }

    public Watch findById(Long id){
        return this.em.find(Watch.class, id);
    }

    public void removeById(Watch watch){
        em.remove(watch);
    }

    public Watch update(Watch watch){
        return em.merge(watch);
        //update v db a vrati novou managed entitu
    }

}
