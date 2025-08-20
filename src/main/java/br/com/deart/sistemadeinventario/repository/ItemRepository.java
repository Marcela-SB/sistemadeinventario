package br.com.deart.sistemadeinventario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deart.sistemadeinventario.model.Item;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID>{
    public boolean existsByTombo(String tombo);
    public List<Item> searchByTombo(String tombo);
    public List<Item> searchByName(String name);
}
