package com.example.springjpa.service;

import com.example.springjpa.model.entity.Accounts;
import com.example.springjpa.model.request.AccountLogin;
import com.example.springjpa.model.request.AccountRequest;

import java.util.List;

public interface IAccountService {
    Accounts getAccount(Long id);

    List<Accounts> getAll();

    Accounts login(AccountLogin request);

    Accounts create(AccountRequest request);

    Accounts update(Long id, AccountRequest request);

    Accounts delete(Long id , AccountRequest request);

}
