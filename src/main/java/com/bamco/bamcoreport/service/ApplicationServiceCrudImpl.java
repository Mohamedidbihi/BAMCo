package com.bamco.bamcoreport.service;

import com.bamco.bamcoreport.dto.*;
import com.bamco.bamcoreport.entity.*;
import com.bamco.bamcoreport.repository.*;
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
    RoleRepository roleRepo;

    @Autowired
    ProfileRepository profileRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    MembershipRepository membershipRepo;

    @Autowired
    ProfileMemberRepository profileMemberRepo;

    @Autowired
    UserContactInfoRepository userContactInfoRepo;

    @Autowired
    IMapClassWithDto<Group, GroupDto> groupMapping;

    @Autowired
    IMapClassWithDto<UserEntity, UserDto> userMapping;

    @Autowired
    IMapClassWithDto<Role, RoleDto> roleMapping;

    @Autowired
    IMapClassWithDto<Profile, ProfileDto> profileMapping;

    @Autowired
    IMapClassWithDto<UserMembership, MembershipDto> membershipMapping;

    @Autowired
    IMapClassWithDto<UserContactInfo, UserContactInfoDto> userContactInfoMapping;

    @Autowired
    IMapClassWithDto<ProfileMember, ProfileMemberDto> profileMemberMapping;


    @Override
    public List<GroupDto> findAllGroups() {
        List<Group> groups = this.groupRepo.findAll();
        Type listType = (new TypeToken<List<GroupDto>>() {
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
        Group groupRequest = groupMapping.convertToEntity(groupdto,Group.class);
        Group group = this.groupRepo.save(groupRequest);
        GroupDto userResponse = groupMapping.convertToDto(group, GroupDto.class);
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
    public GroupDto updateGroup(GroupDto groupDto, long id) {
        Group groupEntity = this.groupRepo.findById(id);
        if (groupEntity == null) {
            throw new RuntimeException("null");
        } else {
            groupEntity.setDescription(groupDto.getDescription());
            groupEntity.setDisplayName(groupDto.getDisplayname());
            groupEntity.setName(groupDto.getName());
            groupEntity.setParentPath(groupDto.getParentpath());
            Group group = (Group) this.groupRepo.save(groupEntity);
            GroupDto groupRes = new GroupDto();
            BeanUtils.copyProperties(group, groupRes);
            return groupRes;
        }
    }





    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = this.roleRepo.findAll();
        Type listType = (new TypeToken<List<RoleDto>>() {
        }).getType();
        List<RoleDto> rolesDto = (List)(new ModelMapper()).map(roles, listType);
        return rolesDto;
    }

    @Override
    public RoleDto findRoleById(long id) {
        Role role = this.roleRepo.findById(id).get();
        if (role == null) {
            throw new RuntimeException("No role was found!");
        } else {
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(role, roleDto);
            return roleDto;
        }
    }

    @Override
    public RoleDto addRole(RoleDto roleDto) {
        Role roleRequest = roleMapping.convertToEntity(roleDto, Role.class);
        Role role = this.roleRepo.save(roleRequest);
        RoleDto roleResponse = roleMapping.convertToDto(role, RoleDto.class);
        return roleResponse;
    }

    @Override
    public boolean deleteRole(long id) {
        Role role = this.roleRepo.findById(id).get();
        if (role == null) {
            throw new RuntimeException("No role was found!");
        } else {
            this.roleRepo.delete(role);
        }
        return true;
    }

    @Override
    public RoleDto updateRole(RoleDto roleDto, long id) {
        Role role = this.roleRepo.findById(id).get();
        if (role == null) {
            throw new RuntimeException("No role was found!");
        } else {
            role.setName(roleDto.getName());
            role.setDisplayName(roleDto.getDisplayName());
            role.setDescription(roleDto.getDescription());
            Role updatedRole = (Role) this.roleRepo.save(role);
            RoleDto roleResponse = new RoleDto();
            BeanUtils.copyProperties(updatedRole, roleResponse);
            return roleResponse;
        }
    }





    @Override
    public List<ProfileDto> getAllProfiles() {
        List<Profile> profiles = this.profileRepo.findAll();
        Type listType = (new TypeToken<List<RoleDto>>() {
        }).getType();
        List<ProfileDto> profileDtos = (List)(new ModelMapper()).map(profiles, listType);
        return profileDtos;
    }

    @Override
    public ProfileDto findProfileById(long id) {
        Profile profile = this.profileRepo.findById(id).get();
        if (profile == null) {
            throw new RuntimeException("No profile was found!");
        } else {
            ProfileDto profileDto = new ProfileDto();
            BeanUtils.copyProperties(profile, profileDto);
            return profileDto;
        }
    }

    @Override
    public ProfileDto addProfile(ProfileDto profileDto) {
        Profile profileRequest = profileMapping.convertToEntity(profileDto, Profile.class);

        UserEntity getCreatedBy = this.userRepo.findById(profileRequest.getCreatedBy().getId());
        profileRequest.setCreatedBy(getCreatedBy);
        UserEntity getLastUpdatedBy = this.userRepo.findById(profileRequest.getLastUpdateBy().getId());
        profileRequest.setLastUpdateBy(getLastUpdatedBy);

        Profile profile = this.profileRepo.save(profileRequest);
        ProfileDto profileResponse = profileMapping.convertToDto(profile, ProfileDto.class);
        return profileResponse;
    }

    @Override
    public boolean deleteProfile(long id) {
        Profile profile = this.profileRepo.findById(id).get();
        if (profile == null) {
            throw new RuntimeException("No profile was found!");
        } else {
            this.profileRepo.delete(profile);
        }
        return true;
    }

    @Override
    public ProfileDto updateProfile(ProfileDto profileDto, long id) {
        Profile profile = this.profileRepo.findById(id).get();
        if (profile == null) {
            throw new RuntimeException("No profile was found!");
        } else {
            profile.setName(profileDto.getName());
            profile.setDescription(profileDto.getDescription());
            profile.setLastUpdateBy(profileDto.getLastUpdateBy());

            UserEntity getCreatedBy = this.userRepo.findById(profileDto.getCreatedBy().getId());
            profile.setCreatedBy(getCreatedBy);
            UserEntity getLastUpdatedBy = this.userRepo.findById(profileDto.getLastUpdateBy().getId());
            profile.setLastUpdateBy(getLastUpdatedBy);

            Profile updatedProfile = (Profile) this.profileRepo.save(profile);
            ProfileDto profileResponse = new ProfileDto();
            BeanUtils.copyProperties(updatedProfile, profileResponse);
            return profileResponse;
        }
    }





    @Override
    public List<MembershipDto> getAllMemberships() {
        List<UserMembership> userMemberships = this.membershipRepo.findAll();
        Type listType = (new TypeToken<List<RoleDto>>() {
        }).getType();
        List<MembershipDto> membershipDtos = (List)(new ModelMapper()).map(userMemberships, listType);

        return membershipDtos;
    }

    @Override
    public MembershipDto findMembershipById(long id) {
        UserMembership membership = this.membershipRepo.findById(id).get();
        if (membership == null) {
            throw new RuntimeException("No membership was found!");
        } else {
            MembershipDto membershipDto = new MembershipDto();
            BeanUtils.copyProperties(membership, membershipDto);
            return membershipDto;
        }
    }

    @Override
    public MembershipDto addMembership(MembershipDto membershipDto) {

        UserMembership membershipRequest = membershipMapping.convertToEntity(membershipDto, UserMembership.class);

        UserEntity getUser = this.userRepo.findById(membershipDto.getUserid().getId());
        membershipRequest.setUserid(getUser);
        UserEntity getAssignedBy = this.userRepo.findById(membershipDto.getAssignedBy().getId());
        membershipRequest.setAssignedBy(getAssignedBy);
        Role getRole = this.roleRepo.findById(membershipDto.getRoleId().getId()).get();
        membershipRequest.setRoleId(getRole);
        Group getGroup = this.groupRepo.findById(membershipDto.getGroupId().getId());
        membershipRequest.setGroupId(getGroup);

        UserMembership membership = this.membershipRepo.save(membershipRequest);
        MembershipDto membershipResponse = membershipMapping.convertToDto(membership, MembershipDto.class);
        return membershipResponse;
    }

    @Override
    public boolean deleteMembership(long id) {
        UserMembership membership = this.membershipRepo.findById(id).get();
        if (membership == null) {
            throw new RuntimeException("No membership was found!");
        } else {
            this.membershipRepo.delete(membership);
        }
        return true;
    }

    @Override
    public MembershipDto updateMembership(MembershipDto membershipDto, long id) {
        UserMembership membership = this.membershipRepo.findById(id).get();
        if (membership == null) {
            throw new RuntimeException("No membership was found!");
        } else {
            membership.setUserid(membershipDto.getUserid());
            membership.setAssignedBy(membershipDto.getAssignedBy());
            membership.setGroupId(membershipDto.getGroupId());
            membership.setRoleId(membershipDto.getRoleId());

            UserEntity getUser = this.userRepo.findById(membershipDto.getUserid().getId());
            membership.setUserid(getUser);
            UserEntity getAssignedBy = this.userRepo.findById(membershipDto.getAssignedBy().getId());
            membership.setAssignedBy(getAssignedBy);
            Role getRole = this.roleRepo.findById(membershipDto.getRoleId().getId()).get();
            membership.setRoleId(getRole);
            Group getGroup = this.groupRepo.findById(membershipDto.getGroupId().getId());
            membership.setGroupId(getGroup);

            UserMembership updatedMembership = (UserMembership) this.membershipRepo.save(membership);
            MembershipDto membershipResponse = new MembershipDto();
            BeanUtils.copyProperties(updatedMembership, membershipResponse);
            return membershipResponse;
        }
    }





    @Override
    public List<UserContactInfoDto> getAllUserContactInfo() {
        List<UserContactInfo> userContactInfo = this.userContactInfoRepo.findAll();
        Type listType = (new TypeToken<List<UserDto>>() {
        }).getType();
        List<UserContactInfoDto> userContactInfoDtos = (List)(new ModelMapper()).map(userContactInfo, listType);

        return userContactInfoDtos;
    }

    @Override
    public UserContactInfoDto findUserContactInfoById(long id) {
        UserContactInfo userContactInfo = this.userContactInfoRepo.findById(id).get();
        if (userContactInfo == null) {
            throw new RuntimeException("No contact info were found!");
        } else {
            UserContactInfoDto userContactInfoDto = new UserContactInfoDto();
            BeanUtils.copyProperties(userContactInfo, userContactInfoDto);
            return userContactInfoDto;
        }
    }

    @Override
    public UserContactInfoDto addUserContactInfo(UserContactInfoDto userContactInfoDto) {
        UserContactInfo userContactInfoRequest = userContactInfoMapping.convertToEntity(userContactInfoDto, UserContactInfo.class);

        UserEntity getUser = this.userRepo.findById(userContactInfoDto.getUserid().getId());
        userContactInfoRequest.setUserEntity(getUser);

        UserContactInfo userContactInfo = this.userContactInfoRepo.save(userContactInfoRequest);
        UserContactInfoDto userContactInfoResponse = userContactInfoMapping.convertToDto(userContactInfo, UserContactInfoDto.class);
        return userContactInfoResponse;
    }


    @Override
    public UserContactInfoDto updateUserContactInfo(UserContactInfoDto userContactInfoDto, long id) {
        UserContactInfo userContactInfo = this.userContactInfoRepo.findById(id).get();
        if (userContactInfo == null) {
            throw new RuntimeException("No contact info were found!");
        } else {
            userContactInfo.setEmail(userContactInfoDto.getEmail());
            userContactInfo.setNumber(userContactInfoDto.getNumber());
            userContactInfo.setPhone(userContactInfoDto.getPhone());
            userContactInfo.setFax(userContactInfoDto.getFax());
            userContactInfo.setCountry(userContactInfoDto.getCountry());
            userContactInfo.setState(userContactInfoDto.getState());
            userContactInfo.setCity(userContactInfoDto.getCity());
            userContactInfo.setAdress(userContactInfoDto.getAdress());
            userContactInfo.setZipcode(userContactInfoDto.getZipcode());
            userContactInfo.setBuilding(userContactInfoDto.getBuilding());
            userContactInfo.setRoom(userContactInfoDto.getRoom());
            userContactInfo.setPersonal(userContactInfoDto.getPersonal());
            userContactInfo.setWebsite(userContactInfoDto.getWebsite());

            UserEntity getUser = this.userRepo.findById(userContactInfoDto.getUserid().getId());
            userContactInfo.setUserEntity(getUser);

            UserContactInfo updatedUserContactInfo = (UserContactInfo) this.userContactInfoRepo.save(userContactInfo);
            UserContactInfoDto userContactInfoResponse = new UserContactInfoDto();
            BeanUtils.copyProperties(updatedUserContactInfo, userContactInfoResponse);
            return userContactInfoResponse;
        }
    }





    @Override
    public List<ProfileMemberDto> getAllProfileMembers() {
        List<ProfileMember> profileMembers = this.profileMemberRepo.findAll();
        Type listType = (new TypeToken<List<UserDto>>() {
        }).getType();
        List<ProfileMemberDto> profileMemberDtos = (List)(new ModelMapper()).map(profileMembers, listType);

        return profileMemberDtos;
    }

    @Override
    public ProfileMemberDto findProfileMemberById(long id) {
        ProfileMember profileMember = this.profileMemberRepo.findById(id).get();
        if (profileMember == null) {
            throw new RuntimeException("No profile member was found!");
        } else {
            ProfileMemberDto profileMemberDto = new ProfileMemberDto();
            BeanUtils.copyProperties(profileMember, profileMemberDto);
            return profileMemberDto;
        }
    }

    @Override
    public ProfileMemberDto addProfileMember(ProfileMemberDto profileMemberDto) {
        ProfileMember profileMemberRequest = profileMemberMapping.convertToEntity(profileMemberDto, ProfileMember.class);

        UserEntity getUser = this.userRepo.findById(profileMemberDto.getUserId().getId());
        profileMemberRequest.setUserId(getUser);
        Role getRole = this.roleRepo.findById(profileMemberDto.getRoleId().getId()).get();
        profileMemberRequest.setRoleId(getRole);
        Group getGroup = this.groupRepo.findById(profileMemberDto.getGroupId().getId());
        profileMemberRequest.setGroupId(getGroup);
        Profile getProfile = this.profileRepo.findById(profileMemberDto.getProfileId().getId()).get();
        profileMemberRequest.setProfileId(getProfile);

        ProfileMember profileMember = this.profileMemberRepo.save(profileMemberRequest);
        ProfileMemberDto profileMemberResponse = profileMemberMapping.convertToDto(profileMember, ProfileMemberDto.class);
        return profileMemberResponse;
    }

    @Override
    public boolean deleteProfileMember(long id) {
        ProfileMember profileMember = this.profileMemberRepo.findById(id).get();
        if (profileMember == null) {
            throw new RuntimeException("No profile member was found!");
        } else {
            this.profileMemberRepo.delete(profileMember);
        }
        return true;
    }

    @Override
    public ProfileMemberDto updateProfileMember(ProfileMemberDto profileMemberDto, long id) {
        ProfileMember profileMember = this.profileMemberRepo.findById(id).get();
        if (profileMember == null) {
            throw new RuntimeException("No profile member was found!");
        } else {
            profileMember.setUserId(profileMemberDto.getUserId());
            profileMember.setRoleId(profileMemberDto.getRoleId());
            profileMember.setGroupId(profileMemberDto.getGroupId());
            profileMember.setProfileId(profileMemberDto.getProfileId());

            ProfileMember updatedProfileMember = (ProfileMember) this.profileMemberRepo.save(profileMember);
            ProfileMemberDto profileMemberResponse = new ProfileMemberDto();
            BeanUtils.copyProperties(updatedProfileMember, profileMemberResponse);
            return profileMemberResponse;
        }
    }

}

