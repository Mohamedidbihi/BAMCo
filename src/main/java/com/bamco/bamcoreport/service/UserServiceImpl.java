package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.repository.UserRepository;
import com.bamco.bamcoreport.service.mapper.IMapClassWithDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserSevice {
    @Autowired
    UserRepository userRepo;

    @Autowired
    IMapClassWithDto<UserEntity, UserDto> userMapping;

    public UserDto createUser(UserDto userDto) {

        ModelMapper mp = new ModelMapper();
        UserEntity userRequest = userMapping.convertToEntity(userDto,UserEntity.class);
        UserEntity user = this.userRepo.save(userRequest);
        //UserDto userResponse = userMapping.convertToDto(user, UserDto.class);
        UserDto userResponse = (UserDto)mp.map(user, UserDto.class);
        return userResponse;
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
    @Override
    public UserDto updateUser(long id, UserDto userDto) {
        UserEntity userEntity = this.userRepo.findById(id);
        if (userEntity == null) {
            throw new RuntimeException("null");
        } else {
            userEntity.setFirstname(userDto.getFirstname());
            userEntity.setLastname(userDto.getLastname());
            userEntity.setEncryptedpassword(userDto.getEncryptedpassword());
            UserEntity userEn = (UserEntity)this.userRepo.save(userEntity);
            UserDto userD = new UserDto();
            BeanUtils.copyProperties(userEn, userD);
            return userD;
        }
    }

     @Override
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
        List<UserEntity> users = this.userRepo.findAll();
        Type listType = (new TypeToken<List<UserDto>>() {
        }).getType();
        List<UserDto> userDtos = (List)(new ModelMapper()).map(users, listType);
        return userDtos;

      //Solution2 return userMapping.convertListToListDto(users,UserDto.class);
    }
}
