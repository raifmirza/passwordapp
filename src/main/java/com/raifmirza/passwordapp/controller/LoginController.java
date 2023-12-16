package com.raifmirza.passwordapp.controller;

import com.raifmirza.passwordapp.User.WebUser;
import com.raifmirza.passwordapp.entity.User;
import com.raifmirza.passwordapp.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class LoginController {
    private UserServiceImpl userService;

    @Autowired
    public LoginController(UserServiceImpl theUserService){
        this.userService = theUserService;
    }

    @GetMapping("/")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> users(){
        List<User> users= userService.findUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<WebUser> register(@Valid @RequestBody WebUser webUser, HttpSession httpSession){
        String userName = webUser.getUserName();

        User existing = userService.findByUserName(userName);
        userService.save(webUser);

        httpSession.setAttribute("user", webUser);

        return new ResponseEntity<>(webUser,HttpStatus.OK);
    }
}
