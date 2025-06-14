package com.magz014.notasapi.dto.response;

import com.magz014.notasapi.model.RoleModel;
import com.magz014.notasapi.model.UserModel;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDTO {

    public  Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private RoleDTO role;


    public UserResponseDTO(UserModel userModel){
        this.id = userModel.getId();
        this.name = userModel.getName();
        this.username = userModel.getUsername();
        this.email = userModel.getEmail();
        this.phone = userModel.getPhone();
        this.createdAt = userModel.getCreatedAt();
        this.updatedAt= userModel.getUpdatedAt();

        if (userModel.getRole() != null) {
            this.role = new RoleDTO(userModel.getRole());
        }
    }

    @Getter
    public static class RoleDTO{
        private String role;

        public RoleDTO(RoleModel roleModel){
            this.role = roleModel.getRole().name();
        }
    }
}
