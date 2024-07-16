package com.unsocial.app;

import com.unsocial.app.model.UserDetails;
import com.unsocial.app.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class unsocialController {

    @Autowired
    private UserService service;

    @PostMapping("register")
    public String registerUser(@RequestBody UserDetails user){
        return service.registerUser(user);
    }

    @GetMapping("login")
    public boolean logInUser(@RequestParam String userName, @RequestParam String password){
        return service.logInUser(userName, password);
    }

    @GetMapping("user/{username}")
    public UserDetails getUser(@PathVariable String username){
        return service.getUser(username);
    }

    @GetMapping("user-prof")
    public List<UserDetails> getUserByProfession(@RequestBody UserDetails user){
        return service.getUserByProfession(user.getProfession());
    }

    @GetMapping("user-comp")
    public List<UserDetails> getUserByCompany(@RequestBody UserDetails user){
        return service.getUserByCompany(user.getCompany());
    }

    @GetMapping("user-city")
    public List<UserDetails> getUserByCity(@RequestBody UserDetails user){
        return service.getUserByCity(user.getCity());
    }

//    @GetMapping("user-techstack")
//    public List<UserDetails> getUserByTechStack(@RequestBody UserDetails user){
//        return service.getUserByTechStack(user.getTechstack());
//
//    }

    @GetMapping("load")
    public String loadDate(){

        service.load();

        return "Loaded....";
    }
}
