package com.example.demo.controller;

import com.example.demo.entities.ChildOTO;
import com.example.demo.entities.ParentOTO;
import com.example.demo.repo.ChildOTORepository;
import com.example.demo.repo.ParentOTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class childOTOController {

    @Autowired
    private ChildOTORepository repository;

    @Autowired
    private ParentOTORepository parentRepository;

    @PostMapping(path="childOTO")
    public ChildOTO createChild() {
        ParentOTO parent = parentRepository.getOne(1L);
        ChildOTO child = new ChildOTO();
        child.setName("prova");
        child.setParent(parent);
        parent.setChild(child);
        return repository.save(child);
    }
}
