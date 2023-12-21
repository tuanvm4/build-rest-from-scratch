package com.example.tuanvm4rest.Repository;

import com.example.tuanvm4rest.Entity.CustomerNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerNameRepository extends JpaRepository<CustomerNameEntity, Integer> {
    List<CustomerNameEntity> findAllByIdIsNotNull();


}
