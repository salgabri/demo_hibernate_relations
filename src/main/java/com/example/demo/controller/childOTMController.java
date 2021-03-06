package com.example.demo.controller;

import com.example.demo.entities.ChildOTM;
import com.example.demo.entities.ChildOTMProjection;
import com.example.demo.entities.ParentOTM;
import com.example.demo.repo.ChildOTMEagerRepository;
import com.example.demo.repo.ChildOTMRepository;
import com.example.demo.repo.ParentOTMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class childOTMController {


    @Autowired
    private ParentOTMRepository parentRepository;

    @Autowired
    private ChildOTMRepository childRepository;

    @Autowired
    private ChildOTMEagerRepository childEagerRepository;

    @PostMapping(path = "childOTM")
        public ChildOTM childOTM() {
        ChildOTM child = new ChildOTM();
        child.setName("figlio");

        ParentOTM parent = new ParentOTM();
        parent.setName("parent");
        child.setParent(parent);
        return childRepository.save(child);
    }

    @GetMapping(path = "child/{id}")
    public ChildOTM getChild(@PathVariable Long id) {
        ChildOTM result = childRepository.findById(id).orElse(null);

        System.out.print(result.getParent().getName());
        return result;
    }

    @DeleteMapping(path = "child/{id}")
    public void deleteChild(@PathVariable Long id) {
        childRepository.deleteById(id);
    }

    @GetMapping(path = "child/projection/all")
    public List<ChildOTMProjection> getProjection() {
        return childRepository.getAllChildProjection();
    }

}
