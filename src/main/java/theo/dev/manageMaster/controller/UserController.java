package theo.dev.manageMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import theo.dev.manageMaster.repository.UserRepository;
import theo.dev.manageMaster.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import theo.dev.manageMaster.entities.AppUser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<AppUser> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser currentUser = (AppUser) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<AppUser>> allUsers() {
        List<AppUser> users = userService.allUsers();
        return ResponseEntity.ok(users);
    }




}