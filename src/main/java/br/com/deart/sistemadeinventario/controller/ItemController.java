package br.com.deart.sistemadeinventario.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deart.sistemadeinventario.dto.ItemRequest;
import br.com.deart.sistemadeinventario.dto.ItemResponse;
import br.com.deart.sistemadeinventario.model.Item;
import br.com.deart.sistemadeinventario.model.Note;
import br.com.deart.sistemadeinventario.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping
    public ResponseEntity<List<ItemResponse>> findAllItems() {
        List<Item> list = service.findAllItems();
        List<ItemResponse> response = ItemResponse.fromList(list);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/tombo/{tombo}")
    public ResponseEntity<List<ItemResponse>> searchByTombo(@PathVariable String tombo) {
        List<Item> list = service.searchItemByTombo(tombo);
        List<ItemResponse> response = ItemResponse.fromList(list);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ItemResponse>> searchByName(@PathVariable String name) {
        List<Item> list = service.searchItemByName(name);
        List<ItemResponse> response = ItemResponse.fromList(list);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable UUID id){
        service.deleteItemById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createItem(@RequestBody ItemRequest request) {
        Item item = new Item(
            request.getTombo(),
            request.getName(), 
            request.getDescription()
        );

        String noteText = request.getNoteText();
        
        if (noteText != null && !noteText.isBlank()) {
            Note note = new Note(item, noteText);
            item.setNote(note);
        }

        service.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateItem(@RequestBody ItemRequest request) {
        Item item = service.findItemById(request.getId());

        item.setTombo(request.getTombo());
        item.setName(request.getName());
        item.setDescription(request.getDescription());

        String newNoteText = request.getNoteText();

        if (newNoteText != null && !newNoteText.isBlank()) {
            if (item.getNote() == null) {
                item.setNote(new Note(item, newNoteText));
            } 
            else if (!newNoteText.equals(item.getNote().getText())) {
                item.getNote().setText(newNoteText);
            }
        } 
        else {
            item.setNote(null);
        }

        service.updateItem(item);
        return ResponseEntity.ok().build();
    }
}
