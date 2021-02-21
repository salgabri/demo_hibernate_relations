package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "child_otm")
@Data
public class ChildOTM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "extra")
    private String extra;

    @Column(name = "extra_two")
    private String extraTwo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("children")
    private ParentOTM parent;
}
