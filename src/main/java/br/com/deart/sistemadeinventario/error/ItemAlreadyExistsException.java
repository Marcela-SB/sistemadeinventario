package br.com.deart.sistemadeinventario.error;

import org.springframework.http.HttpStatus;

public class ItemAlreadyExistsException extends HttpError{
    public ItemAlreadyExistsException() {
        super("Item com esse tombo já existe!", HttpStatus.CONFLICT);
    }

}
