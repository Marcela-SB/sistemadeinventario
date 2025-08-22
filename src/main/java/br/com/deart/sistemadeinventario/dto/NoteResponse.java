package br.com.deart.sistemadeinventario.dto;

import java.util.List;

import br.com.deart.sistemadeinventario.model.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {
    private String text;


    public static List<NoteResponse> fromList(List<Note> notes){
        return notes.stream().map(note -> 
            new NoteResponse(note.getText())
        ).toList();
    }
}
