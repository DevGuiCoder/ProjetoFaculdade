package com.projeto.backend.controllers;

import com.projeto.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        boolean isAuthenticated = authService.login(username, password);
        Map<String, Object> response = new HashMap<>();

        if (isAuthenticated) {
            response.put("success", true);
            response.put("token", "seu_token_aqui"); // Exemplo de token gerado
        } else {
            response.put("success", false);
            response.put("error", "Usuário ou senha incorretos");
        }
        return response;
    }
}