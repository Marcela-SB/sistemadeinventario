package br.com.deart.sistemadeinventario.dto;

import java.util.List;
import java.util.UUID;

import br.com.deart.sistemadeinventario.model.Item;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
    private UUID id;
    private String tombo;
    private String name;
    private String description;

    public static List<ItemResponse> fromList(List<Item> list){
        return list.stream()
            .map(item -> 
                new ItemResponse(
                    item.getId(),
                    item.getTombo(),
                    item.getName(),
                    item.getDescription()
                )
            )
            .toList();
    }

}
