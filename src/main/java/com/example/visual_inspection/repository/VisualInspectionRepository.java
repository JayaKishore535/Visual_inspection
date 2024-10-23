package com.example.visual_inspection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.visual_inspection.model.VisualInspection;

public interface VisualInspectionRepository extends JpaRepository<VisualInspection, Long> {

}
