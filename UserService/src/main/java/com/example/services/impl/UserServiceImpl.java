package com.example.services.impl;

import com.example.entities.User;
import com.example.exceptions.ResourcesNotFoundException;
import com.example.paylode.DeleteResponse;
import com.example.repositories.UserRepository;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public User getUser(String id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElseThrow(() -> new ResourcesNotFoundException("User not found give id " + id));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String id , User user) {
      User existingUser =  this.getUser(id);
      existingUser.setFirstName(user.getFirstName());
      existingUser.setLastName(user.getLastName());
      existingUser.setEmail(user.getEmail());
      return userRepository.save(existingUser);
    }

    @Override
    public DeleteResponse deleteUser(String id) {
        User user =  this.getUser(id);
        userRepository.delete(user);
        return DeleteResponse.builder().message("User deleted successfully").status(true).build();
    }
}
