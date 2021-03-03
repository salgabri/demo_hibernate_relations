package com.example.demo.repo;

import com.example.demo.entities.ParentOTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentOTORepository extends JpaRepository<ParentOTO, Long> {

}