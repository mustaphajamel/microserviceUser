package com.imaginepartners.microservice.user.controllers;


import com.imaginepartners.microservice.user.entities.User;
import com.imaginepartners.microservice.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/users"})
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    ResponseEntity<List<User>> all() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }


    @PostMapping(path ="/add", consumes = "application/json", produces = "application/json")
    ResponseEntity addPanel(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/Delete/{id}")
    ResponseEntity delete(@PathVariable final Long id){
        userRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable final Long id) {

        return userRepository.findById(id).map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }

}
