package com.bamco.bamcoreport.service;


import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.request.PasswordChangeRequest;

import java.util.Collection;
import java.util.List;

public interface UserSevice  {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(long id);

    UserDto updateUser(long id, UserDto userDto);

    void deleteUser(long id);

    List<UserDto> getAllUsers();

    boolean changePassword(long id, PasswordChangeRequest passwordChangeRequest);

}
