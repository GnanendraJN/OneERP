package org.oneerp.product.controller;

import org.oneerp.exceptions.ProductExistsException;
import org.oneerp.product.entities.Product;
import org.oneerp.product.service.ProductService;
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
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getUsers(){
        /*List<Product> users = new ArrayList<>();
        users.add(new Product(101,"Jacku", "Jack", "B", "Admin", "22MAY2021"));
        users.add(new Product(102,"Chintu", "Chintu", "Ramnujam", "Admin", "22MAY2005"));
        //long id, String username, String firstname, String lastName, String role, String ssn
        //return null;*/
        List<Product> products = productService.getProducts();
        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getUserById(@PathVariable("id") Long id)  {

        System.out.println("Inside controller. Finding products id r " + id);
        try{
            Optional<Product> product = productService.getUserById(id);
            HttpStatus status = null;
            if(product.isPresent()){
                status = HttpStatus.OK;
                return new ResponseEntity<>(product.get(), status);
            }
            status = HttpStatus.NOT_FOUND;

            return new ResponseEntity<>(null, status);
        }catch (org.kalike.springboot.exceptions.ProductNotFoundException exp){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exp.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody Product product, UriComponentsBuilder builder){
        try {
            Product created = productService.createProduct(product);

            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/api/products/{id}").buildAndExpand(product.getId()).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }catch (ProductExistsException exp){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exp.getMessage());
        }
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable("id") Long id, @RequestBody Product product)  {
        //product.setId(id);
        try {
            Product updatedProduct = productService.updateUserById(id, product);
        }catch(org.kalike.springboot.exceptions.ProductNotFoundException exp){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exp.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        productService.deleteUserById(id);
    }

    @GetMapping("/productName/{name}")
    public Product getUserByName(@PathVariable String name){

        return productService.getUserByName(name);
    }
}
