package com.example.services;


import com.example.entities.User;
import com.example.paylode.DeleteResponse;

import java.util.List;

public interface UserService  {


    /**
     * This method save user in database
     * @param user
     * @return new create user
     */
    User saveUser(User user);

    /**
     * This method find user by id
     * @param id
     * @return single user
     */
    User getUser(String id);

    /**
     * This method get all users
     * @return list of users
     */
    List<User> getAllUser();


    /**
     * This method update existing user
     * @param id
     * @return updated user
     */
    User updateUser(String id , User user);


    /**
     * This method delete existing user
     * @param id
     * @return DeleteResponse DTO
     */
    DeleteResponse deleteUser(String id);



}
