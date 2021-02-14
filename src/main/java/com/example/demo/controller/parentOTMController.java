package com.example.demo.controller;

import com.example.demo.entities.ParentOTM;
import com.example.demo.repo.ParentOTMRepository;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class parentOTMController {

    @Autowired
    private ParentOTMRepository repository;

    @GetMapping(path = "parentOTM")
    public ParentOTM parentOTM() {

        ParentOTM parent = new ParentOTM();
        parent.setName("pippo");
        return repository.save(parent);
    }
}
