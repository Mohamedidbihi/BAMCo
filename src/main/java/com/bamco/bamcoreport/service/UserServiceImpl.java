package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.repository.UserRepository;
import com.bamco.bamcoreport.service.mapper.IMapClassWithDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserSevice {
    @Autowired
    UserRepository userRepo;

    @Autowired
    IMapClassWithDto<UserEntity, UserDto> userMapping;

    public UserEntity createUser(UserEntity userDto) {
            if (userDto != null) {
                this.userRepo.save(userDto);
            }
            return userDto;
    }

    public UserDto getUserById(long id) {
        UserEntity userEntity = this.userRepo.findById(id);
        if (userEntity == null) {
            throw new RuntimeException("error");
        } else {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity, userDto);
            return userDto;
        }
    }

    public UserDto updateUser(long id, UserDto userDto) {
        UserEntity userEntity = this.userRepo.findById(id);
        if (userEntity == null) {
            throw new RuntimeException("null");
        } else {
            userEntity.setFirstname(userDto.getFirstName());
            userEntity.setLastname(userDto.getLastName());
            userEntity.setEncryptedpassword(userDto.getPassword());

            UserEntity userEn = (UserEntity)this.userRepo.save(userEntity);
            UserDto userD = new UserDto();
            BeanUtils.copyProperties(userEn, userD);
            return userD;
        }
    }


    public void deleteUser(long id) {
        UserEntity userEntity = this.userRepo.findById(id);
        if (userEntity == null) {
            throw new RuntimeException("null");
        } else {
            this.userRepo.delete(userEntity);
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepo.findAll();
        return userMapping.convertListToListDto(users,UserDto.class);
    }
}
