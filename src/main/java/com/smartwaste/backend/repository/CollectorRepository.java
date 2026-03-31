package com.smartwaste.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartwaste.backend.entity.Collector;

public interface CollectorRepository extends JpaRepository<Collector, Long> {
    Optional<Collector> findByUsername(String username);
}
