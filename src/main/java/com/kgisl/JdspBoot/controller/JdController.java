package com.kgisl.JdspBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;

import com.kgisl.JdspBoot.entity.Login;
import com.kgisl.JdspBoot.repository.LoginRepository;

public class JdController {
    @Autowired
    LoginRepository loginrep;
    
 
    @GetMapping("/")
    @ResponseBody
    public List<Login> getall(){
       return loginrep.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Login> getTeamById(@PathVariable("id") int id) {
    Login login = loginrep.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
        // if (user == null) {
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
    @PostMapping(value = "/SaveUser", headers = "Accept=application/json")
    public ResponseEntity<Login> createTeam(@RequestBody Login User) {
        Login actualUser = loginrep.save(User);
        HttpHeaders headers = new HttpHeaders();
        // headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(team.getTeamid()).toUri());
        return new ResponseEntity<>(actualUser, headers, HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Login> updateUser(@PathVariable("id") int id, @RequestBody Login currentUser) {
        Login login = loginrep.save(currentUser);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Login> deleteUser(@PathVariable("id") int id) {
       loginrep.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
