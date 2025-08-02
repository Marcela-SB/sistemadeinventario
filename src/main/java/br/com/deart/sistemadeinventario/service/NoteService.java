package br.com.deart.sistemadeinventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.deart.sistemadeinventario.model.Item;
import br.com.deart.sistemadeinventario.model.Note;
import br.com.deart.sistemadeinventario.repository.NoteRepository;

@Service
public class NoteService {
    @Autowired
    private NoteRepository repository;

    public void saveNote(Note note){
        repository.save(note);
    }

    public void deleteNote(Note note) throws NotFoundException {
        Optional<Note> result = repository.findById(note.getId());
        if (result == null) throw new NotFoundException();

        repository.delete(note);
    }

    public List<Note> searchNotesByItem(Item item){
        return repository.searchByItem(item);
    }

    public List<Note> findAllNotes(){
        return repository.findAll();
    }
}
