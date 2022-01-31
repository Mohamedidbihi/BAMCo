package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.entity.Group;

import java.util.List;

public interface IApplicationServiceCrud {

    List<Group> findAllGroups();

    Group findGroupById(long id);

    Group addGroup(Group r);

    boolean deleteGroup(long id);

    Group updateGroup(Group r, long id);

}
