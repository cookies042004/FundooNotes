package com.example.FundoNotesApp.service;

import com.example.FundoNotesApp.dto.ReminderDto;
import com.example.FundoNotesApp.entity.Note;
import com.example.FundoNotesApp.producer.ReminderProducer;
import com.example.FundoNotesApp.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    @Autowired
    private ReminderProducer reminderProducer;

    private final NoteRepository noteRepository;

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note updatePin(Long id) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setPinned(!note.isPinned());
        return noteRepository.save(note);
    }

    public Note updateArchive(Long id) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setArchived(!note.isArchived());
        return noteRepository.save(note);
    }

    public Note updateTrash(Long id) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setTrash(!note.isTrash());
        return noteRepository.save(note);
    }

    public void setReminder(ReminderDto dto) {
        reminderProducer.sendReminder(dto);
    }
}