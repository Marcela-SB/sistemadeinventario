package br.com.deart.sistemadeinventario.error;

import org.springframework.http.HttpStatus;

public class ItemNotFoundException extends HttpError{
    public ItemNotFoundException() {
        super("Item não encontrado!", HttpStatus.NOT_FOUND);
    }

}
