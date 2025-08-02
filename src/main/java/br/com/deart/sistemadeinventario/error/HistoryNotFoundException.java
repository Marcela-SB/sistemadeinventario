package br.com.deart.sistemadeinventario.error;

import org.springframework.http.HttpStatus;

public class HistoryNotFoundException extends HttpError{
    public HistoryNotFoundException() {
        super("Histórico de item não encontrado!", HttpStatus.NOT_FOUND);
    }

}
