package com.backend.myTicket.service;

import com.backend.myTicket.entity.User;
import com.backend.myTicket.request.UserRequest;

public interface UserService {
    User save(UserRequest userRequest);
    User update(String username, UserRequest userRequest);
    User findById(String username);
    User convertToUser(UserRequest userRequest);

}
