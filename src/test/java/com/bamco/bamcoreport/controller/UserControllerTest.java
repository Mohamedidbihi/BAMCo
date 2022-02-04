package com.bamco.bamcoreport.controller;

import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.repository.UserRepository;
import com.bamco.bamcoreport.service.UserServiceImpl;
import com.bamco.bamcoreport.service.mapper.IMapClassWithDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserControllerTest {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepo;

    @Autowired
    IMapClassWithDto<UserEntity, UserDto> userMapping;

    @Test
    void getUser() {
        when(userRepo.findById(12)).thenReturn(
                new UserEntity(
                                12,
                                true,
                                "idbihi",
                                "hashedPassword",
                                "Med",
                                "Idbihi",
                                "Dev",
                                "Java Developer",
                                new UserEntity(),
                                new UserEntity(),
                                LocalDateTime.now(),
                                LocalDateTime.now()
                        )
        );

        assertNotNull(userService.getUserById(12));
    }


    @Test
    void getAllUsers() {
        when(userRepo.findAll()).thenReturn(
                Stream.of(
                        new UserEntity(
                                12,
                                true,
                                "idbihi",
                                "hashedPassword",
                                "Med",
                                "Idbihi",
                                "Dev",
                                "Java Developer",
                                new UserEntity(),
                                new UserEntity(),
                                LocalDateTime.now(),
                                LocalDateTime.now()
                        ),
                        new UserEntity(
                                15,
                                true,
                                "oth",
                                "hashedPassword",
                                "Othmane",
                                "Oth",
                                "Dev",
                                "Java Developer",
                                new UserEntity(),
                                new UserEntity(),
                                LocalDateTime.now(),
                                LocalDateTime.now()
                        )
                ).collect(Collectors.toList())
        );

        assertEquals(2, userService.getAllUsers().size());
    }


    @Test
    void createUser() {
        UserDto userDto = new UserDto(
                true,
                "gggg",
                "hash",
                "Med",
                "Idbihi",
                "Dev",
                "Java Developer",
                new UserEntity(1),
                new UserEntity(1)
        );

        UserEntity user = userMapping.convertToEntity(userDto, UserEntity.class);

        when(userRepo.save(user)).thenReturn(user);
        assertNotNull(userRepo.save(user));
    }


    @Test
    void deleteUser() {
        UserEntity user = new UserEntity(
                2,
                true,
                "oth",
                "hashedPassword",
                "Othmane",
                "Oth",
                "Dev",
                "Java Developer",
                new UserEntity(1),
                new UserEntity(1)
        );

        userRepo.save(user);
        userRepo.delete(user);
        // verify(userRepo, times(1)).delete(user);
    }
}