package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.dto.*;
import com.bamco.bamcoreport.dto.CountDayDto;
import org.springframework.web.multipart.MultipartFile;

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



    List<UserContactInfoDto> getAllUserContactInfo();

    UserContactInfoDto findUserContactInfoById(long id);

    UserContactInfoDto addUserContactInfo(UserContactInfoDto r);

    UserContactInfoDto updateUserContactInfo(UserContactInfoDto r, long id);



    List<ProfileMemberDto> getAllProfileMembers();

    ProfileMemberDto findProfileMemberById(long id);

    ProfileMemberDto addProfileMember(ProfileMemberDto r);

    boolean deleteProfileMember(long id);

    ProfileMemberDto updateProfileMember(ProfileMemberDto r, long id);



    List<RejetDto> getAllRejets();

    RejetDto findRejetById(long id);

    RejetDto addRejet(RejetDto r, MultipartFile file);

    boolean deleteRejet(long id);

    RejetDto updateRejet(RejetDto r, long id, MultipartFile file);

    long getRejetsCount();

    List<CountDayDto> getRejetsByDay();

    List<CountDayDto> getRejetsByUser(long id);

    String writeFile(MultipartFile file, long registrationNumber) throws Exception;

}
