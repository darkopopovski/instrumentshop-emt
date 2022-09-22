package com.mk.ukim.instrumentshop.model.dto;


import com.mk.ukim.instrumentshop.model.Users;
import com.mk.ukim.instrumentshop.model.enumerations.Role;
import lombok.Data;

@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(Users user) {
        UserDetailsDto details = new UserDetailsDto();
        details.username = user.getUser_username();
        details.role = user.getRole();
        return details;
    }
}
