package br.com.deart.sistemadeinventario.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.deart.sistemadeinventario.model.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    public User findByCpf(String cpf);
    public List<User> searchByName(String name);
}
