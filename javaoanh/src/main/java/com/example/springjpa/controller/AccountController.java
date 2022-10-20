package com.example.springjpa.controller;

import com.example.springjpa.model.entity.Accounts;
import com.example.springjpa.model.request.AccountLogin;
import com.example.springjpa.model.request.AccountRequest;
import com.example.springjpa.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @PostMapping("/login")
    ResponseEntity<Accounts> login(@RequestBody AccountLogin request) {
        Accounts account = service.login(request);
        if (account == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(account);
    }

    @GetMapping("all")
    ResponseEntity<List<Accounts>> getAll() {
        List<Accounts> accounts = service.getAll();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping
    ResponseEntity<Accounts> create(@RequestBody AccountRequest request) {
        Accounts account = service.create(request);
        return ResponseEntity.ok(account);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Accounts> update(@PathVariable(name = "id") Long id, @RequestBody AccountRequest request) {
        Accounts response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<List<Accounts>> delete(@PathVariable(name = "id") Long id) {
//        return ResponseEntity.ok(service.delete());
//    }
}
