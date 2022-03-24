package org.kalike.springboot.user.service;

import org.kalike.springboot.exceptions.UserExistsException;
import org.kalike.springboot.exceptions.UserNotFoundException;
import org.kalike.springboot.user.dao.UserRepository;
import org.kalike.springboot.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user) throws UserExistsException {
        System.out.println("Before saving " + user);
        if(userRepository.findByUsername(user.getUsername()) != null){
            throw new UserExistsException("User already exists in the repository");
        }
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) throws UserNotFoundException{
        System.out.println("Inside service layer And id is - " + id);
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public User updateUserById(Long id, User user) throws UserNotFoundException{

        if(!userRepository.findById(user.getId()).isPresent()){
            throw new UserNotFoundException("User is not found in user repository. Please provide a valid user id. ");
        }

        user.setId(id);
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public void deleteUserById(Long id)  {
        if(!userRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in the repo to delete");
        }else{
            userRepository.deleteById(id);
        }
    }

    public User getUserByName(String name){
        //return userRepository.findByName
        return userRepository.findByUsername(name);
    }

}
