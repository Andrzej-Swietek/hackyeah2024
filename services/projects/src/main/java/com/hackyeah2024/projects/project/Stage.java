package com.hackyeah2024.projects.project;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "stage")
public class Stage {

    @Id
    @SequenceGenerator(
            name = "stage_sequence",
            sequenceName = "stage_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stage_sequence"
    )
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false)
    private Integer stageOrder; // To define the order of stages

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("stageOrder ASC")
    private Set<Stage> stages;

    @ManyToOne
    @JoinColumn(name = "current_stage_id")
    private Stage currentStage; // To track the current stage of the project
}
