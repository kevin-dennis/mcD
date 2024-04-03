package com.mcdonald.mcdonald.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcdonald.mcdonald.Models.UserModel;


public interface UserRepository extends JpaRepository<UserModel,UUID> {
    UserModel findByUserName(String userName);
}
