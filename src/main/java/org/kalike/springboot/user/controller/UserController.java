package org.kalike.springboot.user.controller;

import org.kalike.springboot.exceptions.UserExistsException;
import org.kalike.springboot.exceptions.UserNotFoundException;
import org.kalike.springboot.user.entities.User;
import org.kalike.springboot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        /*List<User> users = new ArrayList<>();
        users.add(new User(101,"Jacku", "Jack", "B", "Admin", "22MAY2021"));
        users.add(new User(102,"Chintu", "Chintu", "Ramnujam", "Admin", "22MAY2005"));
        //long id, String username, String firstname, String lastName, String role, String ssn
        //return null;*/
        List<User> users = userService.getUsers();
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id)  {

        System.out.println("Inside controoler laye . Finding userd id r " + id);
        try{
            return userService.getUserById(id);
        }catch (UserNotFoundException exp){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exp.getMessage());
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder){
        try {
            User created = userService.createUser(user);

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }catch (UserExistsException exp){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exp.getMessage());
        }
    }

    @PutMapping("/users/{id}")
    public void updateUserById(@PathVariable("id") Long id, @RequestBody User user)  {
        //user.setId(id);
        try {

            User updatedUser = userService.updateUserById(id, user);
        }catch(UserNotFoundException exp){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exp.getMessage());
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }

    @GetMapping("/users/username/{name}")
    public User getUserByName(@PathVariable String name){

        return userService.getUserByName(name);
    }
}
