package br.com.deart.sistemadeinventario.model;

import java.util.UUID;

import br.com.deart.sistemadeinventario.dto.ItemRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    private UUID id;

    private String tombo;
    private String name;
    private String description;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private Note note;


    public Item(ItemRequest request){
        this.tombo = request.getTombo();
        this.name = request.getName();
        this.description = request.getDescription();
    }

    public Item(String tombo, String name, String description){
        this.tombo = tombo;
        this.name = name;
        this.description = description;
    }
}
