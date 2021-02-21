package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parent_otm")
@Getter
@Setter
public class ParentOTM {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARENT_OTM_SEQ")
    @SequenceGenerator(name = "PARENT_OTM_SEQ", sequenceName = "parent_otm_id_seq", allocationSize = 100)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("parent")
    private List<ChildOTM> children;

    public void addChild(ChildOTM child) {
        child.setParent(this);
        if(children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public void removeChild(ChildOTM child) {
        child.setParent(null);
        children.remove(child);
    }

    public void addChildren(List<ChildOTM> newChildren) {
        for(ChildOTM child : newChildren) {
            child.setParent(this);
        }

        if(this.children == null) {
            this.children = new ArrayList<>();
        }
        children.addAll(newChildren);
    }}
