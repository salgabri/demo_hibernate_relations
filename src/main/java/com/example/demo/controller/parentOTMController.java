package com.example.demo.controller;

import com.example.demo.entities.ParentOTM;
import com.example.demo.repo.ChildOTMRepository;
import com.example.demo.repo.ParentOTMRepository;
import com.example.demo.services.ParentOTMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class parentOTMController {

    @Autowired
    private ParentOTMRepository parentRepository;

    @Autowired
    private ChildOTMRepository childRepository;

    @Autowired
    private ParentOTMService parentOTMService;


    @PostMapping(path = "parentOTM")
    public ParentOTM parentOTM() {
        return parentOTMService.createNewParent();
    }

    @DeleteMapping(path = "parent/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentRepository.deleteById(id);
    }


    @GetMapping(path = "parent/{id}")
    public ParentOTM getParent(@PathVariable Long id) {
        return this.parentRepository.findById(id).orElse(null);
    }
}
