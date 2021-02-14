package com.example.demo.repo;

import com.example.demo.entities.ParentOTM;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentOTMRepository extends CrudRepository<ParentOTM, Long> {

}
