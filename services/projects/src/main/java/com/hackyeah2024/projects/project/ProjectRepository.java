package com.hackyeah2024.projects.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Page<Project> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Project> findByNgoID(Long ngoID, Pageable pageable);

    Page<Project> findByCategoryAndStatus(String category, String status, Pageable pageable);

    Page<Project> findByEstimatedVolunteersBetween(Integer minVolunteers, Integer maxVolunteers, Pageable pageable);
}

