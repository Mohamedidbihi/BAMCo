package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.repository.UserRepository;
import com.bamco.bamcoreport.service.mapper.IMapClassWithDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(UserDto userDto) {

        userDto.setEncryptedpassword(bCryptPasswordEncoder.encode(userDto.getEncryptedpassword()));
        UserEntity userRequest = userMapping.convertToEntity(userDto,UserEntity.class);
        System.out.println("************************** CREATE USER ENTITY : " + userRequest.getManageruserid());
         UserDto getManagerUserId = this.getUserById(userRequest.getManageruserid().getId());
         userRequest.setManageruserid(userMapping.convertToEntity(getManagerUserId,UserEntity.class));
            UserDto getCreatedBy = this.getUserById(userRequest.getCreatedby().getId());
            userRequest.setCreatedby(userMapping.convertToEntity(getCreatedBy,UserEntity.class));
        UserEntity user = this.userRepo.save(userRequest);
        UserDto userResponse = userMapping.convertToDto(user, UserDto.class);
        return userResponse;
    }

    public UserDto getUserById(long id) {

        System.out.println("************************** GET USER ID : "+ id);
        UserEntity userEntity = this.userRepo.findById(id);
        System.out.println("************************** USER ENTITY : " + userEntity);

        if (userEntity == null) {
           throw new RuntimeException("error");
            //return  null;
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
            throw new RuntimeException("No user was found!");
        } else {
            userEntity.setFirstname(userDto.getFirstname());
            userEntity.setLastname(userDto.getLastname());
            userEntity.setEncryptedpassword(this.bCryptPasswordEncoder.encode(userDto.getEncryptedpassword()));
            UserEntity userEn = (UserEntity)this.userRepo.save(userEntity);
            UserDto userD = new UserDto();
            BeanUtils.copyProperties(userEn, userD);
            return userD;
        }
    }

     @Override
    public void deleteUser(long id) {
         System.out.println("************************** DELETE ID : "+ id);
         UserEntity userEntity = this.userRepo.findById(id);
         System.out.println("************************** DELETE ENTITY : " + userEntity);
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
