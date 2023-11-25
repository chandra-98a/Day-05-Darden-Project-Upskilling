package com.capgemini.SpringBootRest.Service;




import java.util.List;

import com.capgemini.Springboot.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Long userId);
}
