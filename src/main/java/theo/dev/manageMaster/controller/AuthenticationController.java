package theo.dev.manageMaster.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import theo.dev.manageMaster.dtos.LoginResponse;
import theo.dev.manageMaster.dtos.LoginUserDto;
import theo.dev.manageMaster.dtos.RegisterUserDto;
import theo.dev.manageMaster.entities.AppUser;
import theo.dev.manageMaster.services.AuthenticationService;
import theo.dev.manageMaster.services.JwtService;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }
    @PostMapping("/signup")
    public ResponseEntity<AppUser> register(@RequestBody RegisterUserDto registerUserDto) {
        AppUser registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        AppUser authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}