package org.oneerp.about;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oneerp/")
public class AboutUsController {

    @GetMapping("/aboutUs")
    public String aboutUs(){
        return "We are One ERP";
    }

    @GetMapping("/contactUs")
    public ContactDetails contactUs(){
        return new ContactDetails("OneERP", "oneerp@mail", "Bengaluru", "+911234567899");
    }


    // uri - /hello
    //GET method
    // return type - string
    //@RequestMapping(path = "/hello", method = RequestMethod.GET)
//    @GetMapping("/")
//    public String greeting(){
//        return "Welcome to OneERP";
//    }

    // GET - /helloworld-bean
    // input - NA
    // returns - ContactDetails JSON

    /*@GetMapping("/helloworld-bean")
    public ContactDetails getUserDetails(){
        return new ContactDetails("Jack", "Balaka", "Jarmali");
    }*/


}
