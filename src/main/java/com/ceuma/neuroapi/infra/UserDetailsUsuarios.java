package com.ceuma.neuroapi.infra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ceuma.neuroapi.application.repositories.UsuarioRepository;
import com.ceuma.neuroapi.domain.models.Usuario;

@Service
public class UserDetailsUsuarios implements UserDetailsService {

    @Autowired
    private UsuarioRepository uRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario us = uRepository.findByNome(username).orElseThrow();

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + us.getTipoUsuario().toString());

        return new User(us.getNome(),us.getSenha(),List.of(authority));
    }
    
}
