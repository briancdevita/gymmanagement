package com.example.gymmanagement.controller.AuthController;


import com.example.gymmanagement.dto.LoginRequest;
import com.example.gymmanagement.dto.RegisterRequest;
import com.example.gymmanagement.exception.ErrorCode;
import com.example.gymmanagement.exception.ErrorResponse;
import com.example.gymmanagement.exception.GymManagementExeption;
import com.example.gymmanagement.jwtUtils.JwtUtils;
import com.example.gymmanagement.model.Client;
import com.example.gymmanagement.model.Role;
import com.example.gymmanagement.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class AuthController {



    private final AuthenticationManager authenticationManager;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(), loginRequest.getPassword());

        authenticationManager.authenticate(authToken);
        String token = jwtUtils.generateToken(loginRequest.getEmail());

        return ResponseEntity.ok(token);


    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {

        if(clientRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new GymManagementExeption(
                    ErrorCode.DUPLICATE_RESOURCE,
                    "Email is already in use: " + registerRequest.getEmail()
            );
        }

        Client client = new Client();
        client.setFirstName(registerRequest.getFirstName());
        client.setLastName(registerRequest.getLastName());
        client.setEmail(registerRequest.getEmail());
        client.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        if (registerRequest.getRole() != null) {
            client.setRole(Role.valueOf(registerRequest.getRole()));
        } else {
            client.setRole(Role.CLIENT);
        }

        clientRepository.save(client);

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(registerRequest.getEmail(), registerRequest.getPassword());

        authenticationManager.authenticate(authToken);

        String token = jwtUtils.generateToken(registerRequest.getEmail());

        return ResponseEntity.ok(token);
    }
}
