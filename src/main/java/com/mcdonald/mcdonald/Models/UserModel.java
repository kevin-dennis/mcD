package com.mcdonald.mcdonald.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Entity
@Component
@Data
@Table(name = "user_details")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    private UUID id;

    @Column(unique = true)
    private String userName;

    private String password;

}