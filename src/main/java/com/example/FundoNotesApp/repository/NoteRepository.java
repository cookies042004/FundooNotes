package com.example.FundoNotesApp.repository;

import com.example.FundoNotesApp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}