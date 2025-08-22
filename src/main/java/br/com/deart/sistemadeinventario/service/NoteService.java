package br.com.deart.sistemadeinventario.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deart.sistemadeinventario.error.NoteAlreadyExistsException;
import br.com.deart.sistemadeinventario.error.NoteNotFoundException;
import br.com.deart.sistemadeinventario.model.Note;
import br.com.deart.sistemadeinventario.repository.NoteRepository;

@Service
public class NoteService {
    @Autowired
    private NoteRepository repository;

    public void createNote(Note note){
        boolean exists = repository.existsById(note.getId());
        if (exists) throw new NoteAlreadyExistsException();
        repository.save(note);
    }

    public void updateNote(Note updatedNote){
        Note existingNote = repository.findById(updatedNote.getId())
            .orElseThrow(NoteNotFoundException::new);
            
        String newText = updatedNote.getText();
        if (newText != null && !newText.isEmpty() && !newText.equals(existingNote.getText())) {
            existingNote.setText(newText);
            repository.save(existingNote);
        }
        else {
            repository.delete(existingNote);
        }
    }

    public void deleteNoteById(UUID id) {
        Note note = repository.findById(id)
            .orElseThrow(NoteNotFoundException::new);
        repository.delete(note);
    }

    public Note findNoteById(UUID id){
        return repository.findById(id)
            .orElseThrow(NoteNotFoundException::new);
    }

    public List<Note> findAllNotes(){
        return repository.findAll();
    }
}
