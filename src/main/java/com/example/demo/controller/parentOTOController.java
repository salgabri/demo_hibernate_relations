package com.example.demo.controller;

import com.example.demo.entities.ChildOTO;
import com.example.demo.entities.ParentOTO;
import com.example.demo.repo.ParentOTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class parentOTOController {

    @Autowired
    private ParentOTORepository repository;

    @PostMapping(path="parentOTO")
    public ParentOTO createParent() {
        ParentOTO parent = new ParentOTO();
        ChildOTO child = new ChildOTO();
        parent.setName("prova");
        parent.setChild(child);
        child.setParent(parent);
        return repository.save(parent);
    }
}
