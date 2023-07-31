package spring.server.user.mapper;

import org.mapstruct.Mapper;
import spring.server.user.dto.UserDto;
import spring.server.user.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userPostDtoToUser(UserDto.Post requestBody);
    User userPatchDtoToUser(UserDto.Patch requestBody);
    UserDto.Response userToResponseDto(User user);
    List<UserDto.Response> usersToResponseDtos(List<User> users);
}