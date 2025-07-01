package com.magz014.notasapi.dto.response;

import com.magz014.notasapi.model.NoteModel;
import lombok.Value;

@Value
public class NoteResponseDTO {

    Long id;
    String title;
    String description;
    boolean check;
    String colorNote;
    Long userId;
    String username;

    public NoteResponseDTO(NoteModel noteModel){
        this.id = noteModel.getId();
        this.title = noteModel.getTitle();
        this.description = noteModel.getDescription();
        this.check = noteModel.isCheck();
        this.colorNote = noteModel.getColorNote().name();
        this.userId = noteModel.getUser().getId();
        this.username = noteModel.getUser().getUsername();
    }
}
