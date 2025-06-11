package com.magz014.notasapi.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequestDTO {

    @NotBlank(message = "El titulo es obligatorio")
    @Size(min = 1, max = 50, message = "El titulo debe tener entre {min} y {max} caracteres")
    private String title;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre {min} y {max} caracteres")
    private String description;

    @NotNull(message = "El check es obligatorio")
    private Boolean  check;

    @NotBlank(message = "El color de la nota es obligatorio")
    private ColorNote colorNote;

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long userId; // camelCase

    public enum ColorNote {
        VERDE, AZUL, ROJO, AMARILLO, MORADO, BLANCO, GRIS
    }
}
