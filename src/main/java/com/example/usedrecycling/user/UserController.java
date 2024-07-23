package com.example.usedrecycling.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterPostRequest userRegisterPostRequest) {
        userService.registerUser(userRegisterPostRequest);
        return ResponseEntity.status(HttpStatus.OK).body("register successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginPostRequest userLoginPostRequest, HttpSession session) {
        User user = userService.loginUser(userLoginPostRequest);
        if (user != null) {
            session.setAttribute("user", user);
            return ResponseEntity.status(HttpStatus.OK).body("login successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> currentUser(HttpSession session) {
        User user = userService.currentUser(session);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login needed");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpSession session) {
        userService.logoutUser(session);
        return ResponseEntity.status(HttpStatus.OK).body("logout successfully");
    }

    @PatchMapping("/username")
    public ResponseEntity<?> setUsername(@RequestBody SetUserNamePatchRequest setUserNamePatchRequest, HttpSession session) {
        String username = setUserNamePatchRequest.getUsername();
        userService.setUsername(username, session);
        return ResponseEntity.ok("username set successfully");
    }

    @PatchMapping("/password")
    public ResponseEntity<?> setPassword(@RequestBody SetPasswordPatchRequest setPasswordPatchRequest, HttpSession session) {
        String password = setPasswordPatchRequest.getPassword();
        userService.setPassword(password, session);
        return ResponseEntity.ok("password set successfully");
    }
}
