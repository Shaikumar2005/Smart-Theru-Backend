package com.smartwaste.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.smartwaste.backend.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByCollectorId(Long collectorId);

    void deleteByCollectorId(Long collectorId); // ✅ add this
}