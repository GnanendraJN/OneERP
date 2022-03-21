package org.kalike.springboot.user.controller;

import org.kalike.springboot.user.entities.User;
import org.kalike.springboot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public Optional<User> getUserById(@PathVariable("id") Long id){

        System.out.println("Inside controoler laye . Finding userd id r " + id);
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUserById(@PathVariable("id") Long id, @RequestBody User user){
        user.setId(id);
        userService.updateUserById(user);
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
