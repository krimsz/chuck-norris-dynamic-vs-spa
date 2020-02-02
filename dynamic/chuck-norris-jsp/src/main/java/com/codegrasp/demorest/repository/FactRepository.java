package com.codegrasp.demorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FactRepository extends JpaRepository<FactEntity, String> {
}
