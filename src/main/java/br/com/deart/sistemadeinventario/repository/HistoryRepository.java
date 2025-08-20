package br.com.deart.sistemadeinventario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.deart.sistemadeinventario.model.History;

import java.time.LocalDateTime;
import java.util.List;
import br.com.deart.sistemadeinventario.model.User;
import br.com.deart.sistemadeinventario.model.Item;


@Repository
public interface HistoryRepository extends JpaRepository<History, UUID>{
    public List<History> searchByResponsible(User responsible);
    public List<History> searchByDestination(String destination);
    public List<History> searchByOrigin(String origin);
    public List<History> searchByDateTime(LocalDateTime dateTime);
    public List<History> searchByItem(Item item);
    public void deleteByDateTimeBefore(LocalDateTime dateTime);

    @Query("SELECT h FROM History h WHERE h.origin = :location OR h.destination = :location")
    public List<History> searchByLocation(@Param("location") String location);
}