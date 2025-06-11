package com.magz014.notasapi.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    @NotBlank(message = "El nombre completo es requerido")
    @Size(max = 100, message = "Máximo {max} caracteres")
    private String name;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 3, max = 50, message = "El username debe tener entre {min} y {max} caracteres")
    private String username;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un email válido (ej: usuario@dominio.com)")
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(
            regexp = "^\\+?[0-9]{10,18}$",
            message = "El teléfono debe tener entre 10-18 dígitos (opcionalmente con + al inicio)"
    )
    private String phone;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(
            min = 8,
            max = 64,
            message = "La contraseña debe tener entre {min} y {max} caracteres"
    )
    private String password;

    @NotNull(message = "El rol es obligatorio")
    private Long roleId;
}
