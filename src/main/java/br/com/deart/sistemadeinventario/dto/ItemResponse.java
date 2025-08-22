package br.com.deart.sistemadeinventario.dto;

import java.util.List;
import java.util.UUID;

import br.com.deart.sistemadeinventario.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
    private UUID id;
    private String tombo;
    private String name;
    private String description;
    private NoteResponse note;

    public ItemResponse(UUID id, String tombo, String name, String description){
        this.id = id;
        this.tombo = tombo;
        this.name = name;
        this.description = description;
    }

    public static List<ItemResponse> fromList(List<Item> list){
        return list.stream()
            .map(item -> {
                ItemResponse response = new ItemResponse(
                    item.getId(),
                    item.getTombo(),
                    item.getName(),
                    item.getDescription()
                );

                if (
                    item.getNote() != null && 
                    item.getNote().getText() != null && 
                    !item.getNote().getText().isEmpty()
                ) {
                    response.setNote(new NoteResponse(item.getNote().getText()));
                }

                return response;
            })
            .toList();
    }

}
