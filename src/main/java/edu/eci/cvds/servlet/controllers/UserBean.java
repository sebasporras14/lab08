package edu.eci.cvds.servlet.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import edu.eci.cvds.servlet.model.User;
import edu.eci.cvds.servlet.repositories.RepositoryGuess;
import edu.eci.cvds.servlet.services.ServiceGuess;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@Component
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean  implements Serializable {
    private final RepositoryGuess userRepository;
    @Autowired
    ServiceGuess userService;
    private String userName;
    private String password;
    private List<User> usuarios;

    public UserBean(RepositoryGuess userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsuarios(){
        this.usuarios = userService.getAllUsuario();
        return usuarios;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String login() {
        User usuario = userRepository.findById(userName);
        if (usuario == null || !usuario.getPassword().equals(password)) {
            FacesContext.getCurrentInstance().addMessage("@all", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales erroneas", null));
            return null;
        } else {
            return "welcome.xhtml";
        }
    }
    @Bean
    public CommandLineRunner currentUser() throws Exception{
        return args -> {
            userService.addUsuario(new User("admin", "hola123"));
            userService.addUsuario(new User("sebastian porras rozo", "1014308142"));
            userService.getAllUsuario().forEach(System.out::println);
        };
    }
}