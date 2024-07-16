package com.unsocial.app.service;

import com.unsocial.app.model.UserDetails;
import com.unsocial.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public String registerUser(UserDetails user) {
        repo.save(user);
        return("Saved");
    }

    public boolean logInUser(String userName, String password) {
        UserDetails user = repo.findById(userName).orElse(new UserDetails());
        System.out.println(user.getPassword() + "password in diff" + password);
        return Objects.equals(user.getPassword(), password);
    }

    public void load() {
        List<UserDetails> defaultUsers = new ArrayList<>();
        // Java Developer Job Post
        defaultUsers.add(new UserDetails("@arijit", "arijit@gmail.com", "11111111", "Software Engineer", "SRM University","RSA  Security","Kolkata",
                List.of("Core Java", "JavaScript", "Spring Boot", "React"), List.of("Coding", "Reading"),"08/20/1997"));

        // Frontend Developer Job Post
        defaultUsers.add(
                new UserDetails("@archana", "archana@gmail.com", "11111111", "Software Engineer", "NIT Warangal","RSA  Security","Rajasthan",
                        List.of("Core Java", "Hibernate", "Spring Boot", "Microservice"), List.of("Coding", "Reading"),"05/20/1993"));

        // Data Scientist Job Post
        defaultUsers.add(new UserDetails("@manan", "manan@gmail.com", "11111111", "Software Engineer", "Manipal University","RSA  Security","Gujarat",
                List.of("JavaScript", "Selenium", "Jenkins"), List.of("Coding", "Reading"),"10/15/1993"));

        // Network Engineer Job Post
        defaultUsers.add(new UserDetails("@rachit", "rachit@gmail.com", "11111111", "Software Engineer", "SRM University","RSA  Security","Uttar Pradesh",
                List.of("Core Java", "JavaScript", "Python", "AWS"), List.of("Coding", "Reading"),"11/26/1995"));

        // Mobile App Developer Job Post
        defaultUsers
                .add(new UserDetails("@sandeep", "sandeep@gmail.com", "11111111", "Software Engineer", "Amrita University","RSA  Security","Karnataka",
                        List.of("Core Java", "JavaScript", "Spring Boot"), List.of("Coding", "Reading"),"05/15/1998"));

        repo.saveAll(defaultUsers);

    }

    public UserDetails getUser(String username) {
        UserDetails user = repo.findById(username).orElse(new UserDetails());
        System.out.println(user+"in get user");
        return user;
    }

    public List<UserDetails> getUserByProfession(String profession) {
        return repo.findByProfession(profession);
    }

    public List<UserDetails> getUserByCompany(String company) {
        return repo.findByCompany(company);
    }

    public List<UserDetails> getUserByCity(String city) {
        return repo.findByCity(city);
    }

//    public List<UserDetails> getUserByTechStack(List<String> techstack) {
//        String tech = techstack.get(0);
//        return repo.findByTechstackContaining(tech);
//    }
}
