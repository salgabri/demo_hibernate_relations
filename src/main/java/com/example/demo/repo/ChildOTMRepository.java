package com.example.demo.repo;

import com.example.demo.entities.ChildOTM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildOTMRepository extends CrudRepository<ChildOTM, Long> {
}
