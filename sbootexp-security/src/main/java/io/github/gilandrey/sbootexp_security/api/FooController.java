package io.github.gilandrey.sbootexp_security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    @GetMapping("/public")
    public ResponseEntity<String> publicRout() {
        return ResponseEntity.ok("Public route ok!");
    }
    @GetMapping("/private")
    public ResponseEntity<String> privateRout(Authentication authentication) {
        System.out.println(authentication.getClass());
        return ResponseEntity.ok("Private route ok! Usuario conectado: " + authentication.getName());
    }
}
