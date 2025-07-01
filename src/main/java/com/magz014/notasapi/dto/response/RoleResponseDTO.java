package com.magz014.notasapi.dto.response;

import com.magz014.notasapi.model.RoleModel;
import lombok.Value;

@Value
public class RoleResponseDTO {
     String role;

     public RoleResponseDTO(RoleModel roleModel) {
         this.role = roleModel.getRole().name();
     }
}
