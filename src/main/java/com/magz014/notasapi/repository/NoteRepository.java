package com.magz014.notasapi.repository;

import com.magz014.notasapi.model.NoteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NoteModel,Long> {
}
