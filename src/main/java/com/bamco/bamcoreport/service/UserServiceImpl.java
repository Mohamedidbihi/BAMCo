package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.entity.UserMembership;
import com.bamco.bamcoreport.repository.MembershipRepository;
import com.bamco.bamcoreport.repository.UserRepository;
import com.bamco.bamcoreport.request.PasswordChangeRequest;
import com.bamco.bamcoreport.service.mapper.IMapClassWithDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserSevice , UserDetailsService {

    @Autowired
    MembershipRepository membershipRepository;

    @Autowired
    UserRepository userRepo;

    @Autowired
    IMapClassWithDto<UserEntity, UserDto> userMapping;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(UserDto userDto) {

        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getpassword()));
        UserEntity userRequest = userMapping.convertToEntity(userDto, UserEntity.class);
        UserDto getManagerUserId = this.getUserById(userRequest.getManageruserid().getId());
        userRequest.setManageruserid(userMapping.convertToEntity(getManagerUserId, UserEntity.class));
        UserDto getCreatedBy = this.getUserById(userRequest.getCreatedby().getId());
        userRequest.setCreatedby(userMapping.convertToEntity(getCreatedBy, UserEntity.class));
        UserEntity user = this.userRepo.save(userRequest);
        UserDto userResponse = userMapping.convertToDto(user, UserDto.class);
        return userResponse;
    }

    public UserDto getUserById(long id) {

        UserEntity userEntity = this.userRepo.findById(id);

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
            userEntity.setPassword(this.bCryptPasswordEncoder.encode(userDto.getpassword()));
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

    @Override
    public boolean changePassword(long id, PasswordChangeRequest passwordChangeRequest) {

        boolean matches = false;

        UserEntity user = this.userRepo.findById(id);
        if (user == null) {
            throw new RuntimeException("null");
        } else {
            matches = bCryptPasswordEncoder.matches(passwordChangeRequest.getOldPassword(), user.getPassword());
        }

        System.out.println("State is : " + matches);

        if (matches){
            user.setPassword(bCryptPasswordEncoder.encode(passwordChangeRequest.getNewPassword()));
            this.userRepo.save(user);
        }

        return matches;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if (userRepo.findByUsername(username)!=null){
            UserEntity user = userRepo.findByUsername(username);
            List<UserMembership> userMemberShip = membershipRepository.findUserMemberShipByUserid(user);
            userMemberShip.forEach(role ->{
                authorities.add(new SimpleGrantedAuthority(role.getRoleId().getName()));
            });

            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
        }else throw  new UsernameNotFoundException("This UserName "+username+" Not found ");
    }
}
