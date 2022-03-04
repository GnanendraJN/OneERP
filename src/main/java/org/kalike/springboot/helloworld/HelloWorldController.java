package org.kalike.springboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // uri - /hello
    //GET method
    // return type - string
    //@RequestMapping(path = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String greeting(){
        return "Welcome to Spring Boot REST";
    }

    // GET - /helloworld-bean
    // input - NA
    // returns - UserDetails JSON

    @GetMapping("/helloworld-bean")
    public UserDetails getUserDetails(){
        return new UserDetails("Jack", "Balaka", "Jarmali");
    }
}
