package com.unsocial.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    @Id
    private String username;
    private String email;
    private String password;
    private String profession;
    private String collage;
    private String company;
    private String city;
    private List<String> techstack;
    private List<String> interests;
    private String dob;
}
