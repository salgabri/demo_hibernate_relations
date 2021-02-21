package com.example.demo.repo;

import com.example.demo.entities.ParentOTM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentOTMRepository extends JpaRepository<ParentOTM, Long> {

    @Query(value = "SELECT p FROM ParentOTM p LEFT JOIN FETCH p.children WHERE p.id = ?1")
    ParentOTM findByIdFull(Long id);

}
