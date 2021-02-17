package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Value
public class ChildOTMProjection {

    private Long id;
    private String name;

    public ChildOTMProjection(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
