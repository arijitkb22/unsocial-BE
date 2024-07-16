package com.unsocial.app.repo;

import com.unsocial.app.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, String > {

    List<UserDetails> findByProfession(String profession);

    List<UserDetails> findByCompany(String company);

    List<UserDetails> findByCity(String city);

//    @Query("SELECT u FROM UserDetails u JOIN u.tech t WHERE t = :tech")
//    List<UserDetails> findByTechstackContaining(String tech);
}
