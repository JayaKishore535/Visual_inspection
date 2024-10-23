package com.example.visual_inspection.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.visual_inspection.model.VisualInspection;
import com.example.visual_inspection.repository.VisualInspectionRepository;

@RestController
@RequestMapping("/visual_inspection")
public class VisualInspectionController {

    @Autowired
    private VisualInspectionRepository repository;

    @GetMapping
    public List<VisualInspection> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisualInspection> getById(@PathVariable("id") Long id) {
        Optional<VisualInspection> visualInspection = repository.findById(id);
        return visualInspection.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VisualInspection> create(@RequestBody VisualInspection visualInspection) {
        VisualInspection savedInspection = repository.save(visualInspection);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInspection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisualInspection> update(@PathVariable("id") Long id, @RequestBody VisualInspection visualInspection) {
        Optional<VisualInspection> existingInspection = repository.findById(id);
        if (existingInspection.isPresent()) {
            visualInspection.setId(id);
            return ResponseEntity.ok(repository.save(visualInspection));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build(); // 404 Not Found
    }
}
