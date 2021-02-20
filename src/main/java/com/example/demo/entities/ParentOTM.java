package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parent_otm")
@Getter
@Setter
public class ParentOTM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
