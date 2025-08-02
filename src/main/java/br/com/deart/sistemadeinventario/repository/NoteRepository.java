package br.com.deart.sistemadeinventario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deart.sistemadeinventario.model.Note;
import br.com.deart.sistemadeinventario.model.Item;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
    public Note findByItem(Item item);
}
