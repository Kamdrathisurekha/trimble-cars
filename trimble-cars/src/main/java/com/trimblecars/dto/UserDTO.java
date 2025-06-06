package com.trimblecars.dto;

import com.trimblecars.entity.Role;
import lombok.Data;



@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private Role role;
    
    

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

	
}
