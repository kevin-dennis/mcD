package com.mcdonald.mcdonald.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcdonald.mcdonald.Models.UserModel;
import com.mcdonald.mcdonald.Repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUserService(UserModel user) {
        userRepository.save(user);
        return "User registered";
    }
    @Transactional
    public String deleteUser (String userName){
        if (userRepository.existsByUserName (userName)) {
        userRepository.deleteByUserName(userName);
        return "User removed !! " + userName;
    }
    else {
       return "User does not exist ";
    }
    }

    public String loginService(UserModel user) {
        UserModel userFromDB = userRepository.findByUserName(user.getUserName());
        if (userFromDB != null) {
            if (userFromDB.getPassword().equals(user.getPassword())) {
                return "Login successfully";
            } else {
                return "Invalid username or password";
            }
        } else {
            return "Invalid username or password";
        }
    }
    public UserModel updateUser(UserModel user){
        UserModel existinguser = userRepository.findByUserName(user.getUserName());
        
        existinguser.setPassword(user.getPassword());
        return userRepository.save(existinguser);
    }

}
