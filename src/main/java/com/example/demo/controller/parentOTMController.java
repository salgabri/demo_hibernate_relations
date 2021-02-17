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

    @PostMapping(path = "childOTM")
    public ChildOTM childOTM() {

        ChildOTM child = new ChildOTM();
        child.setName("figlio");

        Optional<ParentOTM> parent = parentRepository.findById(4L);
        child.setParent(parent.get());
        return childRepository.save(child);
    }

    @DeleteMapping(path = "child/{id}")
    public void deleteChild(@PathVariable Long id) {
        childRepository.deleteById(id);
    }

    @DeleteMapping(path = "parent/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentRepository.deleteById(id);
    }

    @GetMapping(path = "child/{id}")
    public ChildOTM getChild(@PathVariable Long id) {
        ChildOTM result = childRepository.findById(id).orElse(null);
        return result;
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

    @GetMapping(path = "child/projection/all")
    public List<ChildOTMProjection> getProjection() {
        return childRepository.getAllChildProjection();
    }
}
