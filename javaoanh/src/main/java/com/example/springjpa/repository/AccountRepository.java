package com.example.springjpa.repository;

import com.example.springjpa.model.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByUsernameAndPassword(String username, String password);
    Optional<Accounts> findAccountByUsername(String username);
    List<Accounts> findAll();

}
