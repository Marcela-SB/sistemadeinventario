package br.com.deart.sistemadeinventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deart.sistemadeinventario.model.User;
import br.com.deart.sistemadeinventario.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void saveUser(User user){
        repository.save(user);
    }

    public void deleteUser(User user){
        repository.delete(user);
    }

    public User findUserByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

    public List<User> searchUserByName(String name){
        return repository.searchByName(name);
    }
}
