package com.miro.watcheseshop.rest;

import com.miro.watcheseshop.entity.Watch;
import com.miro.watcheseshop.repository.WatchRepository;
import com.miro.watcheseshop.service.WatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/eshop")
public class WatchResource {

    private final WatchService watchService;

    @Autowired
    public WatchResource(WatchService watchService) {
        this.watchService = watchService;
    }
    @Autowired
    private WatchRepository watchRepository;

    private static Logger log = LoggerFactory.getLogger(WatchResource.class);

    //REST
    @GetMapping
    public List<Watch> getWatches() {
        return watchService.getAllWatches();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Watch>> getAll(){
        List<Watch> watchList = watchService.getAllWatches();

        if(watchList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(watchList);
    }

    //accepts both xml and json, returns HTTP 201
    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    @Transactional
    public ResponseEntity insert(@RequestBody Watch watch){
        Watch resultWatch = this.watchService.insertWatch(watch);

        return new ResponseEntity<>(HttpStatus.CREATED);
        //return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Watch> getWatch(@PathVariable("id") Long id){
        Watch watch = watchService.findById(id);

        if(watch == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(watch);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Watch> delete(@PathVariable("id") Long id){
        Watch watch = watchService.findById(id); //managed

        if(watch == null){
            return ResponseEntity.notFound().build();
        }
        watchRepository.removeById(watch);
        //return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
        //proc nic neposle :(
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Watch> update(@PathVariable ("id") Long id, @RequestBody Watch watch){
        Watch resultWatch = this.watchService.update(watch);
        return ResponseEntity.ok(resultWatch);
    }
}
