package br.com.deart.sistemadeinventario.error;

import org.springframework.http.HttpStatus;

public class NoteAlreadyExistsException extends HttpError{

    public NoteAlreadyExistsException() {
        super("Já existe uma Nota para este Item!", HttpStatus.CONFLICT);
    }

}
