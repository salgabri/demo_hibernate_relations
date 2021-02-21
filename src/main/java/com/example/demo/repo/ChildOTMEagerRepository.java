package com.example.demo.repo;

import com.example.demo.entities.ChildOTMEager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildOTMEagerRepository extends CrudRepository<ChildOTMEager, Long> {
}
