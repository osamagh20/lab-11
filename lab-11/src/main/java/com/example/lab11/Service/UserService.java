package com.example.lab11.Service;

import com.example.lab11.ApiResponse.ApiException;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
       return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id,User user) {
        User oldUser = userRepository.findUsersByUserId(id);

        if (oldUser == null) {
            throw new ApiException("id not found");
        }
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRegistration_date(user.getRegistration_date());
        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {
        User delUser = userRepository.findUsersByUserId(id);
        if (delUser == null) {
            throw new ApiException("id not found");
        }
        userRepository.delete(delUser);

    }

    public List<User> getUsersByRegistrationDate(Date date) {
        List<User> users = userRepository.getUsersByRegistration_date(date);
        if (users == null) {
            throw new ApiException("date not found");
        }
        return users;
    }


}
