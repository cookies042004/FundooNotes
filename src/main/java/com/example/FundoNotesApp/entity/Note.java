package com.example.FundoNotesApp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    private boolean isPinned;
    private boolean isArchived;
    private boolean isTrash;

    @ManyToOne
    private User user;
}
