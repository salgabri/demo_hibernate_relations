package com.example.demo.controller;

import com.example.demo.entities.ChildOTM;
import com.example.demo.entities.ChildOTMProjection;
import com.example.demo.entities.ParentOTM;
import com.example.demo.repo.ChildOTMRepository;
import com.example.demo.repo.ParentOTMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class parentOTMController {

    @Autowired
    private ParentOTMRepository parentRepository;

    @Autowired
    private ChildOTMRepository childRepository;


    @PostMapping(path = "parentOTM")
    public ParentOTM parentOTM() {

        ParentOTM prova = parentRepository.findById(1L).orElse(new ParentOTM());
        ChildOTM child = new ChildOTM();
        child.setName("prova");

        prova.addChild(child);

        child = new ChildOTM();
        child.setName("prova");

        prova.addChild(child);

        child = new ChildOTM();
        child.setName("prova");

        prova.addChild(child);
        return parentRepository.save(prova);
    }

    @DeleteMapping(path = "parent/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentRepository.deleteById(id);
    }


    @GetMapping(path = "parent/{id}")
    public ParentOTM getParent(@PathVariable Long id) {
        //ParentOTM result = parentRepository.findById(id).orElse(null);
        ParentOTM result = parentRepository.findByIdFull(id);
        ChildOTM child = result.getChildren().stream().findFirst().orElse(null);
        result.removeChild(child);
        child = result.getChildren().stream().findFirst().orElse(null);
        result.removeChild(child);
        //result.addChild(new ChildOTM());
        return parentRepository.save(result);
    }
}
