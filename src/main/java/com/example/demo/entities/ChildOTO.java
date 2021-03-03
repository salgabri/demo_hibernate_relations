package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "child_oto")
@Data
public class ChildOTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHILD_OTO_SEQ")
    @SequenceGenerator(name = "CHILD_OTO_SEQ", sequenceName = "child_oto_id_seq", allocationSize = 100)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "extra_two")
    private String extraTwo;

    @JoinColumn(name="parent_id", referencedColumnName = "id")
    @OneToOne
    @JsonIgnoreProperties("child")
    private ParentOTO parent;
}