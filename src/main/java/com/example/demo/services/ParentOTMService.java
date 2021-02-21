package com.example.demo.services;

import com.example.demo.entities.ChildOTM;
import com.example.demo.entities.ParentOTM;
import com.example.demo.repo.ChildOTMRepository;
import com.example.demo.repo.ParentOTMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ParentOTMService {

    @Autowired
    private ParentOTMRepository parentRepository;

    @Autowired
    private ChildOTMRepository childOTMRepository;


    public ParentOTM createNewParent() {
        ParentOTM prova = parentRepository.findById(1L).orElse(new ParentOTM());
        ChildOTM child1 = new ChildOTM();
        child1.setName("prova");

        ChildOTM child2 = new ChildOTM();
        child2.setName("prova");

        ChildOTM child3 = new ChildOTM();
        child3.setName("prova");

        ChildOTM child4 = new ChildOTM();
        child1.setName("prova");

        ChildOTM child5 = new ChildOTM();
        child2.setName("prova");

        ChildOTM child6 = new ChildOTM();
        child3.setName("prova");

        prova.addChild(child1);
        prova.addChild(child2);
        prova.addChild(child3);
        prova.addChild(child4);
        prova.addChild(child5);
        prova.addChild(child6);

        ParentOTM parent = parentRepository.save(prova);
        return parent;
    }

    public ParentOTM updateChildNames(Long id) {
        ParentOTM parent = this.parentRepository.findById(id).orElse(null);
        if(parent != null) {
            List<ChildOTM> children = parent.getChildren();

            for (ChildOTM child : children) {
                child.setName("aaaaa");
            }
        }
        return this.parentRepository.save(parent);
    }
}
