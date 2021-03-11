package com.miro.watcheseshop.service;

import com.miro.watcheseshop.entity.Watch;
import com.miro.watcheseshop.repository.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService {

    @Autowired WatchRepository wr;

    public List<Watch> getAllWatches() {
        return wr.getAll();
    }

    public Watch insertWatch(Watch watch){
        return wr.insert(watch);
    }

    public Watch findById(Long id){
        return wr.findById(id);
    }

    public Watch update(Watch watch){
        return wr.update(watch);
    }





}
