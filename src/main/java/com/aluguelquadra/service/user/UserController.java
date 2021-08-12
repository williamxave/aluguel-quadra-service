package com.aluguelquadra.service.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserDto userDto){
        User user = userDto.toModel();
        userRepository.save(user);
        var response = new UserResponse(user.getName(),user.getExternalId());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{externalId}").buildAndExpand(response.getExternalId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/search/{externalId}")
    public ResponseEntity<UserResponse> search (@PathVariable("externalId") String externalId){
        User user =  userRepository.findByExternalId(externalId)
                .orElseThrow(
                        () -> new IllegalArgumentException("Usuário não encontrado")
                );
        return  ResponseEntity.ok(new UserResponse(user.getExternalId(), user.getName()));
    }

}
