package Gabransel.RegisterLogin.services;


import Gabransel.RegisterLogin.dto.RegisterRequestDto;
import Gabransel.RegisterLogin.dto.RegisterResponseDto;
import Gabransel.RegisterLogin.entities.User;
import Gabransel.RegisterLogin.exceptions.EmailAlreadyExistException;
import Gabransel.RegisterLogin.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponseDto register(RegisterRequestDto dto) {

        if (userRepository.existsByEmail(dto.email())) {
            throw new EmailAlreadyExistException(dto.email());
        }

        Set<User.UserRole> roles = Set.of(User.UserRole.USER);
        String hashedPassword = passwordEncoder.encode(dto.password());

        User newUser = new User(roles,  hashedPassword, dto.email(), dto.name());
        User savedUser = userRepository.save(newUser);

        return new RegisterResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}
