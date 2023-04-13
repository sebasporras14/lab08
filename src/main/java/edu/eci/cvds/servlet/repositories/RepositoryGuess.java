package edu.eci.cvds.servlet.repositories;

import org.springframework.stereotype.Repository;

import edu.eci.cvds.servlet.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RepositoryGuess extends JpaRepository<User, Long>{
    boolean existsById(String propiedadId);

    User findById(String propiedadId);
}
