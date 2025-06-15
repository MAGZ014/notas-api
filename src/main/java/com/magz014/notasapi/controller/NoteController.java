package com.magz014.notasapi.controller;

import com.magz014.notasapi.dto.request.NoteRequestDTO;
import com.magz014.notasapi.dto.response.NoteResponseDTO;
import com.magz014.notasapi.model.NoteModel;
import com.magz014.notasapi.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping
    public List<NoteResponseDTO> getNoteAll() {
        List<NoteModel> noteModels = noteService.getAllNotes();
        return noteModels.stream()
                .map(NoteResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public NoteResponseDTO getNoteById(@PathVariable Long id){
        NoteModel noteModel = noteService.getNoteById(id);
        return new NoteResponseDTO(noteModel);
    }

    @PostMapping
    public NoteResponseDTO createNote(@Valid @RequestBody NoteRequestDTO noteRequestDTO){
        NoteModel noteModel = noteService.createNote(noteRequestDTO);
        return new NoteResponseDTO(noteModel);
    }
    @PutMapping("/{id}")
    public NoteResponseDTO update(@Valid @RequestBody NoteRequestDTO noteRequestDTO, @PathVariable Long id){
        NoteModel noteModel = noteService.updateNote(noteRequestDTO,id);
        return new NoteResponseDTO(noteModel);
    }
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
    }
}
