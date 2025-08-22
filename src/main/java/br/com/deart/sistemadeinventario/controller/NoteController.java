package br.com.deart.sistemadeinventario.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deart.sistemadeinventario.dto.NoteRequest;
import br.com.deart.sistemadeinventario.dto.NoteResponse;
import br.com.deart.sistemadeinventario.model.Item;
import br.com.deart.sistemadeinventario.model.Note;
import br.com.deart.sistemadeinventario.service.ItemService;
import br.com.deart.sistemadeinventario.service.NoteService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getAllNotes(){
        List<Note> notes = noteService.findAllNotes();
        List<NoteResponse> response = NoteResponse.fromList(notes);
        return ResponseEntity.ok().body(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> getNote(@PathVariable UUID id){
        Note note = noteService.findNoteById(id);
        NoteResponse response = new NoteResponse(note.getText());
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable UUID id){
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createNote(@RequestBody NoteRequest request){
        Item item = itemService.findItemById(request.getItemId());
        Note note = new Note(item, request.getText());
        noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateNote(@RequestBody NoteRequest request) {
        Item item = itemService.findItemById(request.getItemId());
        Note note = new Note(item, request.getText());
        noteService.updateNote(note);
        return ResponseEntity.ok().build();
    }
}
