package com.magz014.notasapi.service;

import com.magz014.notasapi.dto.request.UserRequestDTO;
import com.magz014.notasapi.model.RoleModel;
import com.magz014.notasapi.model.UserModel;
import com.magz014.notasapi.repository.RoleRepository;
import com.magz014.notasapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    //Obtener todos los Usarios
    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    //Obtener el Usuario por ID
    public UserModel getUserByID(Long id){
        return userRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Usuario no encontrado por Id:"+id));
    }

    //Crear Usuario
    public UserModel createUser(UserRequestDTO userRequestDTO){
        RoleModel role = roleRepository.findById(userRequestDTO.getRoleId()).
                orElseThrow(()-> new RuntimeException("Rol no encontrado"));

        UserModel user = new UserModel();
        user.setName(userRequestDTO.getName());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setPassword(userRequestDTO.getPassword());

        user.setRole(role);

        return userRepository.save(user);
    }

    //Editar info del usuario
    public UserModel updateUser(UserRequestDTO userRequestDTO, Long id){
        UserModel user = userRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Usuario no encontrado por Id:"+id));

        RoleModel role = roleRepository.findById(userRequestDTO.getRoleId()).
                orElseThrow(()-> new RuntimeException("Rol no encontrado"));

        user.setName(userRequestDTO.getName());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());

        return userRepository.save(user);
    }

    //Eliminar Usuario
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
