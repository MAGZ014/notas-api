package com.magz014.notasapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "note")
public class NoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(name = "is_checked", nullable = false)
    private Boolean check;

    @Enumerated(EnumType.STRING)
    @Column(name = "color_note",nullable = false, length = 20)
    private Colors colorNote;

    public enum Colors {
        VERDE, AZUL, ROJO, AMARILLO, MORADO, BLANCO, GRIS
    }

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private UserModel user;
}
