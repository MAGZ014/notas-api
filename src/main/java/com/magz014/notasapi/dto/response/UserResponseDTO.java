package com.magz014.notasapi.dto.response;

import com.magz014.notasapi.model.UserModel;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class UserResponseDTO {

    Long id;
    String name;
    String username;
    String email;
    String phone;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    RoleResponseDTO role;


    public UserResponseDTO(UserModel userModel){
        this.id = userModel.getId();
        this.name = userModel.getName();
        this.username = userModel.getUsername();
        this.email = userModel.getEmail();
        this.phone = userModel.getPhone();
        this.createdAt = userModel.getCreatedAt();
        this.updatedAt= userModel.getUpdatedAt();

        this.role = userModel.getRole() != null ?
                new RoleResponseDTO(userModel.getRole()) :
                null;
    }

}
