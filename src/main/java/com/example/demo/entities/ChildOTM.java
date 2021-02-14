package com.example.demo.entities;

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
}
