package com.backend.myTicket.controller;


import com.backend.myTicket.entity.User;
import com.backend.myTicket.request.UserRequest;
import com.backend.myTicket.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@Tag(name="User REST API Endpoints", description = "Operations related to users")
public class UserRestController {
    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService){
        userService = theUserService;
    }
    @Operation(summary = "Create an User", description = "Create and returns a new user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public User addUser(@Valid @RequestBody UserRequest theUser){
        User dbUser = userService.save(theUser);
        return dbUser;
    }
    @Operation(summary = "Get an User", description = "Get an User by username")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{username}")
    public User getUser(@PathVariable @Size(min = 5, max = 50) String username) {
        return userService.findById(username);
    }


}
