package com.backend.myTicket.service;

import com.backend.myTicket.entity.User;
import com.backend.myTicket.repository.UserRepository;
import com.backend.myTicket.request.UserRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserServiceImpl  implements  UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }
    @Transactional
    @Override
    public User save(UserRequest userRequest) {
        User theUser = convertToUser(userRequest);
        return userRepository.save(theUser);
    }

    @Override
    public User update(String email, UserRequest userRequest) {
        return null;
    }

    @Override
    public User findById(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found with email: " + email
                ));
    }

    @Override
    public User convertToUser( UserRequest userRequest) {
        return new User(userRequest.getEmail(), userRequest.getFullName(), userRequest.getPassword(), userRequest.getProfilePicture());
    }
}
