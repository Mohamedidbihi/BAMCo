package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.dto.GroupDto;
import com.bamco.bamcoreport.entity.Group;

import java.util.List;

public interface IApplicationServiceCrud {

    List<GroupDto> findAllGroups();

    GroupDto findGroupById(long id);

    GroupDto addGroup(GroupDto r);

    boolean deleteGroup(long id);

    GroupDto updateGroup(GroupDto r, long id);




}
