package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parent_oto")
@Getter
@Setter
public class ParentOTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parent_OTO_SEQ")
    @SequenceGenerator(name = "parent_OTO_SEQ", sequenceName = "parent_oto_id_seq", allocationSize = 100)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("parent")
    private ChildOTO child;

}