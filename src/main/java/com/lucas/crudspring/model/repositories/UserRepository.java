package com.lucas.crudspring.model.repositories;

import com.lucas.crudspring.model.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

    Optional<UserModel> findByUsername(String username);

}
