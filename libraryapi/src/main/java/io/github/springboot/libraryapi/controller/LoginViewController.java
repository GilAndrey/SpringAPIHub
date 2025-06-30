package io.github.springboot.libraryapi.controller;

import io.github.springboot.libraryapi.security.CustomAuthentication;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Tag(name = "Login View")
public class LoginViewController {

    @GetMapping("/login")
    public String paginaLogin(){
        return "login";
    }

    @GetMapping("/")
    @ResponseBody
    public String paginaHome(Authentication authentication) {
        if (authentication instanceof CustomAuthentication customAuth) {
            System.out.println(customAuth.getUsuario());
        }
        return "Olá " + authentication.getName();
    }
    @Operation(summary = "Autorização", description = "Pega autorização do Auth")
    @GetMapping("/authorized")
    @ResponseBody
    public String getAuthorizationCode(@RequestParam("code") String code) { // -> Dont works
        return "Seu Authorization Code " + code;
    }
}
