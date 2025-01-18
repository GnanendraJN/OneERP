package org.oneerp.product.service;

import org.oneerp.exceptions.ProductExistsException;
import org.oneerp.product.dao.ProductRepository;
import org.oneerp.product.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository userRepository;

    public List<Product> getProducts(){
        return userRepository.findAll();
    }

    public Product createProduct(Product product) throws ProductExistsException {
        System.out.println("Before saving " + product);
        if(userRepository.findByName(product.getName()) != null){
            throw new ProductExistsException("Product already exists in the repository");
        }
        return userRepository.save(product);
    }

    public Optional<Product> getUserById(Long id) throws org.kalike.springboot.exceptions.ProductNotFoundException {
        System.out.println("Inside service layer And id is - " + id);
        Optional<Product> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new org.kalike.springboot.exceptions.ProductNotFoundException("Product not found");
        }
        return user;
    }

    public Product updateUserById(Long id, Product user) throws org.kalike.springboot.exceptions.ProductNotFoundException {

        if(!userRepository.findById(user.getId()).isPresent()){
            throw new org.kalike.springboot.exceptions.ProductNotFoundException("Product is not found in user repository. Please provide a valid user id. ");
        }

        user.setId(id);
        Product updatedProduct = userRepository.save(user);
        return updatedProduct;
    }

    public void deleteUserById(Long id)  {
        if(!userRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product not found in the repo to delete");
        }else{
            userRepository.deleteById(id);
        }
    }

    public Product getUserByName(String name){
        //return userRepository.findByName
        return userRepository.findByName(name);
    }
}
