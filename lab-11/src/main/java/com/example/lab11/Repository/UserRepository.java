package com.example.lab11.Repository;

import com.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUsersByUserId(Integer id);

    @Query("select u from User u where u.registration_date<=?1")
    List<User> getUsersByRegistration_date(Date date);


}
