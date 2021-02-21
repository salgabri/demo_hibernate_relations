package com.example.demo.repo;

import com.example.demo.entities.ChildOTM;
import com.example.demo.entities.ChildOTMProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildOTMRepository extends JpaRepository<ChildOTM, Long> {

    @Query(value = "SELECT new com.example.demo.entities.ChildOTMProjection(c.id,c.name) FROM ChildOTM c")
    List<ChildOTMProjection> getAllChildProjection();

    @Query(value = "SELECT c FROM ChildOTM c LEFT JOIN FETCH c.parent")
    List<ChildOTM> getAllChildFetchJoinParent();

    @Override
    @Query(value = "SELECT c FROM ChildOTM c WHERE c.id = :id")
    Optional<ChildOTM> findById(Long id);
}
