package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.dto.GroupDto;
import com.bamco.bamcoreport.dto.UserDto;
import com.bamco.bamcoreport.entity.Group;
import com.bamco.bamcoreport.entity.UserEntity;
import com.bamco.bamcoreport.repository.GroupRepository;
import com.bamco.bamcoreport.service.mapper.IMapClassWithDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service("ApplicationServices")
public class ApplicationServiceCrudImpl implements IApplicationServiceCrud {

    @Autowired
    GroupRepository groupRepo;

    @Autowired
    IMapClassWithDto<Group, GroupDto> userMapping;

    @Override
    public List<GroupDto> findAllGroups() {
        List<Group> groups = this.groupRepo.findAll();
        Type listType = (new TypeToken<List<UserDto>>() {
        }).getType();
        List<GroupDto> groupsDto = (List)(new ModelMapper()).map(groups, listType);
        return groupsDto;
    }

    @Override
    public GroupDto findGroupById(long id) {
        Group groupEntity = this.groupRepo.findById(id);
        if (groupEntity == null) {
            throw new RuntimeException("error");
        } else {
            GroupDto groupDto = new GroupDto();
            BeanUtils.copyProperties(groupEntity, groupDto);
            return groupDto;
        }
    }

    @Override
    public GroupDto addGroup(GroupDto groupdto) {
        Group groupRequest = userMapping.convertToEntity(groupdto,Group.class);
        Group group = this.groupRepo.save(groupRequest);
        GroupDto userResponse = userMapping.convertToDto(group, GroupDto.class);
        return userResponse;
    }

    @Override
    public boolean deleteGroup(long id) {
        Group group = this.groupRepo.findById(id);
        if (group == null) {
            throw new RuntimeException("null");
        } else {
            this.groupRepo.delete(group);
        }
        return true;
    }

    @Override
    public GroupDto updateGroup(GroupDto r, long id) {
        return null;
    }

}
