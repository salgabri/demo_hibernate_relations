package com.example.demo.repo;

import com.example.demo.entities.ChildOTMEager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildOTMEagerRepository extends JpaRepository<ChildOTMEager, Long> {
}
