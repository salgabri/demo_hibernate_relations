package com.example.demo.repo;

import com.example.demo.entities.ChildOTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildOTORepository extends JpaRepository<ChildOTO, Long> {
}