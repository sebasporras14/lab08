package edu.eci.cvds.servlet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.cvds.servlet.model.User;
import edu.eci.cvds.servlet.repositories.RepositoryGuess;

import java.util.List;

@Service
public class ServiceGuess {
    private final RepositoryGuess userRepository;
    @Autowired
    public ServiceGuess(RepositoryGuess usuarioRepository){
        this.userRepository = usuarioRepository;
    }
    public User addUsuario(User usuario){
        return userRepository.save(usuario);
    }
    public User getUsuario (String usuarioId){
        return userRepository.findById(usuarioId);
    }
    public List<User> getAllUsuario(){
        return userRepository.findAll();
    }
    public User updateUsuario(User usuario){
        if(userRepository.existsById(usuario.getId())){
            return userRepository.save(usuario);
        }
        return null;
    }

    public void deleteUsuario(Long usuarioId){
        userRepository.deleteById(usuarioId);
    }

}
