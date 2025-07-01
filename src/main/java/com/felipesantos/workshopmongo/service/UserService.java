package com.felipesantos.workshopmongo.service;

import com.felipesantos.workshopmongo.domain.User;
import com.felipesantos.workshopmongo.dto.UserDTO;
import com.felipesantos.workshopmongo.repository.UserRepository;
import com.felipesantos.workshopmongo.service.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream().map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public UserDTO findById(String id) {
        return userRepository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }

    public UserDTO save(UserDTO userDTO) {
        return new UserDTO(userRepository.insert(User.of(userDTO)));
    }
}
