package com.learnwithranjan.restservices.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.learnwithranjan.restservices.dtos.UserMsDto;
import com.learnwithranjan.restservices.entities.User;

@Mapper(componentModel = "Spring")
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	//user to userMsDto
	
	@Mappings({
		@Mapping(source = "email",target = "emailAddress"),
		@Mapping(source = "role",target = "roleAssigned")
	})
	UserMsDto userToUserMsDto(User user);
	
	//User List<User> to List<UserMsDto>
	List<UserMsDto> userstoUserDtos(List<User> users);
}
