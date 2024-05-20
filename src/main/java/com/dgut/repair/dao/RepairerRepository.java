package com.dgut.repair.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairerRepository extends JpaRepository<Repairer, Integer> {
    Repairer findByName(String name);
}
