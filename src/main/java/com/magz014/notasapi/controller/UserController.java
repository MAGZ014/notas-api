package com.magz014.notasapi.controller;

import com.magz014.notasapi.dto.request.UserRequestDTO;
import com.magz014.notasapi.dto.response.UserResponseDTO;
import com.magz014.notasapi.model.UserModel;
import com.magz014.notasapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> getAllList() {
        List<UserModel> userModels = userService.getAllUsers();
        return userModels.stream()
                .map(UserResponseDTO::new).toList();

    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id){
        UserModel userModel = userService.getUserByID(id);
        return new UserResponseDTO(userModel);
    }

    @PostMapping
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserModel user = userService.createUser(userRequestDTO);
        return new UserResponseDTO(user);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@Valid @PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        UserModel user = userService.updateUser(userRequestDTO,id);
        return  new UserResponseDTO(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
