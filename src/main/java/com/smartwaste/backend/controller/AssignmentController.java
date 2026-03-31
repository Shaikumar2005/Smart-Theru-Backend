package com.smartwaste.backend.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartwaste.backend.entity.Assignment;
import com.smartwaste.backend.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin("*")
public class AssignmentController {

    private final AssignmentService service;

    public AssignmentController(AssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public Assignment assign(
        @RequestParam Long routeId,
        @RequestParam Long collectorId) {
        return service.assignRoute(routeId, collectorId);
    }

    @GetMapping("/collector/{collectorId}")
    public List<Assignment> collectorAssignments(
        @PathVariable Long collectorId) {
        return service.getAssignmentsForCollector(collectorId);
    }
}
