package com.example.FundoNotesApp.controller;

import com.example.FundoNotesApp.entity.Note;
import com.example.FundoNotesApp.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public Note create(@RequestBody Note note) {
        return noteService.create(note);
    }

    @GetMapping
    public List<Note> getAll() {
        return noteService.getAll();
    }

    @PatchMapping("/{id}/pin")
    public Note pin(@PathVariable Long id) {
        return noteService.updatePin(id);
    }

    @PatchMapping("/{id}/archive")
    public Note archive(@PathVariable Long id) {
        return noteService.updateArchive(id);
    }

    @PatchMapping("/{id}/trash")
    public Note trash(@PathVariable Long id) {
        return noteService.updateTrash(id);
    }
}