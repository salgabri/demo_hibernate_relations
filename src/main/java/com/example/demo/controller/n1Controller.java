package com.example.demo.controller;

import com.example.demo.entities.ChildOTM;
import com.example.demo.entities.ChildOTMEager;
import com.example.demo.repo.ChildOTMEagerRepository;
import com.example.demo.repo.ChildOTMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class n1Controller {

    @Autowired
    private ChildOTMRepository childRepository;

    @Autowired
    private ChildOTMEagerRepository childEagerRepository;

    @GetMapping(path = "n1/eager")
    public void testNplusOneEager() {
        List<ChildOTMEager> children = (List<ChildOTMEager>) this.childEagerRepository.findAll();

        for (ChildOTMEager child : children) {
            System.out.println(child.getParent().getName());
        }
    }

    @GetMapping(path = "n1/lazy")
    public void testNplusOneLazy() {
        List<ChildOTM> children = (List<ChildOTM>) this.childRepository.findAll();

        for (ChildOTM child : children) {
            System.out.println(child.getParent().getName());
        }
    }

    @GetMapping(path = "n1/lazyFetchJoin")
    public void testNplusOneLazyFetchJoin() {
        List<ChildOTM> children = (List<ChildOTM>) this.childRepository.getAllChildFetchJoinParent();

        for (ChildOTM child : children) {
            System.out.println(child.getParent().getName());
        }
    }
}
