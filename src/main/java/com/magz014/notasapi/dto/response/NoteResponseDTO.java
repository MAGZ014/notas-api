package com.magz014.notasapi.dto.response;

import com.magz014.notasapi.model.NoteModel;
import lombok.Getter;

@Getter
public class NoteResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Boolean check;
    private String colorNote;
    private Long userId;
    private String username;

    public NoteResponseDTO(NoteModel noteModel){
        this.id = noteModel.getId();
        this.title = noteModel.getTitle();
        this.description = noteModel.getDescription();
        this.check = noteModel.getCheck();
        this.colorNote = noteModel.getColorNote().name();
        this.userId = noteModel.getUser().getId();
        this.username = noteModel.getUser().getUsername();
    }
}
