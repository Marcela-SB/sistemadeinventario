package br.com.deart.sistemadeinventario.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemRequest {
    private UUID id;
    private String tombo;
    private String name;
    private String description;
    private String noteText;
}
