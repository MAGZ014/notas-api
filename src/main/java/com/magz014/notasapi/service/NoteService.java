package com.magz014.notasapi.service;

import com.magz014.notasapi.dto.request.NoteRequestDTO;
import com.magz014.notasapi.enums.Colors;
import com.magz014.notasapi.model.NoteModel;
import com.magz014.notasapi.model.UserModel;
import com.magz014.notasapi.repository.NoteRepository;
import com.magz014.notasapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    public NoteService(UserRepository userRepository, NoteRepository noteRepository){
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    //Obtener todas las notas
    public List<NoteModel> getAllNotes(){
        return noteRepository.findAll();
    }

    //Obtener la nota por ID
    public NoteModel getNoteById(Long id){
        return noteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Nota no encontrada por Id: "+id));
    }

    //Crear nota
    public NoteModel createNote(NoteRequestDTO noteRequestDTO) {
        UserModel user = userRepository.findById(noteRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        NoteModel note = new NoteModel();
        note.setTitle(noteRequestDTO.getTitle());
        note.setDescription(noteRequestDTO.getDescription());
        note.setCheck(noteRequestDTO.getCheck());

        // Conversión segura de String a Enum
        Colors color = Colors.valueOf(noteRequestDTO.getColorNote().toUpperCase());
        note.setColorNote(color);

        note.setUser(user);

        return noteRepository.save(note);
    }

    //Actualizar nota
    public NoteModel updateNote(NoteRequestDTO noteRequestDTO, Long id) {
        NoteModel note = noteRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Nota no encontrada por Id: "+id));

        UserModel user = userRepository.findById(noteRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        note.setTitle(noteRequestDTO.getTitle());
        note.setDescription(noteRequestDTO.getDescription());
        note.setCheck(noteRequestDTO.getCheck());

        Colors color = Colors.valueOf(noteRequestDTO.getColorNote().toUpperCase());
        note.setColorNote(color);

        note.setUser(user);

        return noteRepository.save(note);
    }

    //Eliminar nota
    public void deleteNote(Long id){
        noteRepository.deleteById(id);
    }
}
