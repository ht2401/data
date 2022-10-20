package com.example.springjpa.service;

import com.example.springjpa.model.entity.Accounts;
import com.example.springjpa.model.request.AccountLogin;
import com.example.springjpa.model.request.AccountRequest;
import com.example.springjpa.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public Accounts getAccount(Long id) {
        return null;
    }

    @Override
    public List<Accounts> getAll() {
        return repository.findAll();
    }

    @Override
    public Accounts login(AccountLogin request) {
        Optional<Accounts> account = repository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (account.isEmpty()) {
            log.error("username and password are not match");
            return null;
        }
        return account.get();
    }

    @Override
    public Accounts create(AccountRequest request) {
        Accounts account = new Accounts();
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());
        account.setProfileId(request.getProfileId());
        account.setName(request.getName());
        repository.save(account);
        return account;
    }

    @Override
    public Accounts update(Long id, AccountRequest request) {
        Accounts accounts = repository.getReferenceById(id);
        accounts.setUsername(request.getUsername());
        accounts.setPassword(request.getPassword());
        accounts.setProfileId(request.getProfileId());
        accounts.setName(request.getName());
        repository.save(accounts);
        return new Accounts();
    }

    @Override
    public Accounts delete(Long id, AccountRequest request) {
        Accounts accounts = repository.getReferenceById(Long.valueOf(id));
        accounts.hashCode();
        return new Accounts();
    }


}
