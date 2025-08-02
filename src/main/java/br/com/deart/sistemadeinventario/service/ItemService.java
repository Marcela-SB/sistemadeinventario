package br.com.deart.sistemadeinventario.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deart.sistemadeinventario.error.ItemNotFoundException;
import br.com.deart.sistemadeinventario.model.Item;
import br.com.deart.sistemadeinventario.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public void saveItem(Item item){
        repository.save(item);    
    }

    public void deleteItemById(UUID id){
        repository.deleteById(id);
    }

    public Item findItemById(UUID uuid) throws ItemNotFoundException{
        return repository.findById(uuid).orElseThrow(ItemNotFoundException::new);
    }

    public List<Item> searchItemByTombo(String tombo){
        return repository.searchByTombo(tombo);
    }

    public List<Item> searchItemByName(String name){
        return repository.searchByName(name);
    }

    public List<Item> findAllItems(){
        return repository.findAll();
    }
}
