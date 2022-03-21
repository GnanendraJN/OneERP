package org.kalike.springboot.user.service;

import org.kalike.springboot.user.dao.UserRepository;
import org.kalike.springboot.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        System.out.println("Before saving " + user);
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id){
        System.out.println("Inside service layer And id is - " + id);
        System.out.println("Inside service layer");
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            System.out.println("User is " + user.get());
        }else{
            System.out.println("user objec is empty");
        }

        return user;
        //return userRepository.findById(id);
    }

    public User updateUserById(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }

    public User getUserByName(String name){
        //return userRepository.findByName
        return userRepository.findByUsername(name);
    }

}
