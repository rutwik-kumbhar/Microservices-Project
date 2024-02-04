package com.example.controllers;


import com.example.entities.User;
import com.example.paylode.DeleteResponse;
import com.example.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping("/api/v1/user")
public class UserController {





    private  final UserService userService;




    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        System.out.println(user);
        return  new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public  ResponseEntity<User> getUser(@PathVariable("id") String userId){
        return  new ResponseEntity<User>(userService.getUser(userId),HttpStatus.OK);
    }

    @GetMapping("/all")
    public  ResponseEntity<List<User>> getUsers(){
        return  new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String userId ,@RequestBody  User user){
        return  new ResponseEntity<User>(userService.updateUser(userId,user),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<DeleteResponse> deleteUser(@PathVariable("id") String userId){
        return  new ResponseEntity<DeleteResponse>(userService.deleteUser(userId),HttpStatus.OK);
    }
}
