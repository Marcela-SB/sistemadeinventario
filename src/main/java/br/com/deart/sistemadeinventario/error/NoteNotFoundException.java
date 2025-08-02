package br.com.deart.sistemadeinventario.error;

import org.springframework.http.HttpStatus;

public class NoteNotFoundException extends HttpError {
    public NoteNotFoundException() {
        super("Anotação não encontrada!", HttpStatus.NOT_FOUND);
    }
}
