package br.com.deart.sistemadeinventario.model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

    @Column(unique = true)
    private String tombo;
    
    private String name;
    private String description;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private Note note;

    public Item(UUID id, String tombo, String name, String description){
        this.id = id;
        this.tombo = tombo;
        this.name = name;
        this.description = description;
    }

    public Item(String tombo, String name, String description){
        this.tombo = tombo;
        this.name = name;
        this.description = description;
    }
}
