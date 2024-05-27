package com.gangulwar.expensetracker.controller;

import com.gangulwar.expensetracker.constants.ApiResponse;
import com.gangulwar.expensetracker.constants.AuthResponse;
import com.gangulwar.expensetracker.constants.Response;
import com.gangulwar.expensetracker.entity.AuthRequest;
import com.gangulwar.expensetracker.entity.User;
import com.gangulwar.expensetracker.jwt.service.JwtService;
import com.gangulwar.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/new")
    public ResponseEntity<ApiResponse<User>> newUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> checkUser(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String generatedToken = jwtService.generateToken(authRequest.getUsername());
            return Response.authenticationSuccessful(generatedToken);
        } else {
                    return Response.authenticationUnsuccessful();
//            throw new UsernameNotFoundException("invalid user request !");
        }

    }

}
