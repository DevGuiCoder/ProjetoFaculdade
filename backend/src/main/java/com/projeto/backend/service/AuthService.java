package com.projeto.backend.service;

import com.projeto.backend.model.Usuario;
import com.projeto.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean login(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario != null) {
            return passwordEncoder.matches(password, usuario.getPasswordHash());
        }
        return false;
    }
}