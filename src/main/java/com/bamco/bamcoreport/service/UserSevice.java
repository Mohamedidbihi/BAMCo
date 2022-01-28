package com.bamco.bamcoreport.service;


import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;

import java.util.Collection;
import java.util.List;

public interface UserSevice  {

    UserEntity createUser(UserEntity userDto);

    UserDto getUserById(long id);

    UserDto updateUser(long id, UserDto userDto);

    void deleteUser(long id);

    List<UserDto> getAllUsers();

}
