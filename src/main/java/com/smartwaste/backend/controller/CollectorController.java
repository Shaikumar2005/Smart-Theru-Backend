package com.smartwaste.backend.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartwaste.backend.entity.Collector;
import com.smartwaste.backend.repository.CollectorRepository;

@RestController
@RequestMapping("/api/collectors")
@CrossOrigin("*")
public class CollectorController {

    private final CollectorRepository repo;

    public CollectorController(CollectorRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/login")
    public Collector login(@RequestBody Collector c) {
        return repo.findByUsername(c.getUsername())
            .filter(x -> x.getPassword().equals(c.getPassword()))
            .orElseThrow();
    }

    @GetMapping
    public List<Collector> list() {
        return repo.findAll();
    }
}

