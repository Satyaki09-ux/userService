package com.example.userservice.models;

import com.example.userservice.dtos.UserDto;
import com.example.userservice.repositories.UserRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String email;
    private String password;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    public static UserDto from(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        return userDto;
    }

}
