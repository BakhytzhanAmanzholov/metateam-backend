package kz.metateam.hackday.controllers;

import kz.metateam.hackday.dto.LoginDto;
import kz.metateam.hackday.dto.RegistrationDto;
import kz.metateam.hackday.models.Account;
import kz.metateam.hackday.service.AccountService;
import kz.metateam.hackday.token.JWTAuthResponse;
import kz.metateam.hackday.token.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class HomeController {
    private final AccountService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
        Account person = userService.findByEmail(loginDto.getEmail());
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JWTAuthResponse(token));
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationDto registrationDto) {
        if (userService.findByEmail(registrationDto.getEmail()) != null) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        Account account = new Account();
        account.setFirstName(registrationDto.getFirstName());
        account.setSecondName(registrationDto.getSecondName());
        account.setEmail(registrationDto.getEmail());
        account.setPassword(registrationDto.getPassword());
        userService.save(account);
        return new ResponseEntity<>("User successfully created", HttpStatus.OK);
    }
}
