package br.com.deart.sistemadeinventario.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deart.sistemadeinventario.model.History;
import br.com.deart.sistemadeinventario.model.Item;
import br.com.deart.sistemadeinventario.model.User;
import br.com.deart.sistemadeinventario.repository.HistoryRepository;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository repository;

    public void saveHistory(History history){
        repository.save(history);
    }

    public void deleteHistory(History history){
        repository.delete(history);
    }

    public void deleteHistoryBeforeDate(LocalDateTime dateTime){
        repository.deleteByDateTimeBefore(dateTime);
    }

    public List<History> searchHistoryByDate(LocalDateTime dateTime){
        return repository.searchByDateTime(dateTime);
    }

    public List<History> searcHistoryByItem(Item item){
        return repository.searchByItem(item);
    }

    public List<History> searchHistoryByOrigin(String origin){
        return repository.searchByOrigin(origin);
    }

    public List<History> searchHistoryByDestination(String destination){
        return repository.searchByDestination(destination);
    }

    public List<History> searchHistoryByLocal(String location){
        return repository.searchByLocation(location);
    }

    public List<History> searchHistoryByResponsible(User user){
        return repository.searchByResponsible(user);
    }
}
