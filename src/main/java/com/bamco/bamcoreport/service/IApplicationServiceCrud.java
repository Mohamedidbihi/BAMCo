package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.dto.GroupDto;
import com.bamco.bamcoreport.dto.MembershipDto;
import com.bamco.bamcoreport.dto.ProfileDto;
import com.bamco.bamcoreport.dto.RoleDto;
import com.bamco.bamcoreport.entity.Group;

import java.util.List;

public interface IApplicationServiceCrud {

    List<GroupDto> findAllGroups();

    GroupDto findGroupById(long id);

    GroupDto addGroup(GroupDto r);

    boolean deleteGroup(long id);

    GroupDto updateGroup(GroupDto r, long id);


    List<RoleDto> getAllRoles();

    RoleDto findRoleById(long id);

    RoleDto addRole(RoleDto r);

    boolean deleteRole(long id);

    RoleDto updateRole(RoleDto r, long id);


    List<ProfileDto> getAllProfiles();

    ProfileDto findProfileById(long id);

    ProfileDto addProfile(ProfileDto r);

    boolean deleteProfile(long id);

    ProfileDto updateProfile(ProfileDto r, long id);


    List<MembershipDto> getAllMemberships();

    MembershipDto findMembershipById(long id);

    MembershipDto addMembership(MembershipDto r);

    boolean deleteMembership(long id);

    MembershipDto updateMembership(MembershipDto r, long id);

}
