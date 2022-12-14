package com.mk.ukim.instrumentshop.service.Impl;

import com.mk.ukim.instrumentshop.model.Users;
import com.mk.ukim.instrumentshop.model.enumerations.Role;
import com.mk.ukim.instrumentshop.repo.UsersRepository;
import com.mk.ukim.instrumentshop.service.UsersService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class UsersServiceImpl implements UsersService, UserDetailsService {


    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<Users> findByUsername(String user_username) {
        return this.userRepository.findByUsername(user_username);
    }

    @Override
    public Users findById(Integer user_id) {
        return this.userRepository.findById(user_id).get();
    }

    @Override
    public List<Users> listAll() {
        return this.userRepository.findAll();
    }


    @Override
    public Users register(Integer user_id, String user_username, String user_password, String user_email, String user_name, Role role) {
        Users user = new Users(user_username, passwordEncoder.encode(user_password), user_email, user_name, role);
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(
                user.getUser_username(),
                user.getUser_password(),
                Stream.of(new SimpleGrantedAuthority(user.getUser_role().getAuthority())).collect(Collectors.toList()));
    }
}
