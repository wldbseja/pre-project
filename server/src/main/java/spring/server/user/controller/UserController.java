package spring.server.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.server.response.MultiResponseDto;
import spring.server.response.PageInfo;
import spring.server.response.SingleResponseDto;
import spring.server.user.dto.UserDto;
import spring.server.user.entity.User;
import spring.server.user.mapper.UserMapper;
import spring.server.user.service.UserService;
import spring.server.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/users")
@Validated
@Slf4j
@CrossOrigin
public class UserController {
    private final static String USER_DEFAULT_URL = "/users";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity postUser(@Valid @RequestBody UserDto.Post postDto){
        User user = UserDto.Post.dtoToUser(postDto);
        User createdUser = userService.createUser(user);
        URI location = UriCreator.createUri(USER_DEFAULT_URL, createdUser.getUserId());
        return new ResponseEntity<>(UserDto.Response.response(createdUser), HttpStatus.CREATED);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity patchUser(@PathVariable("userId") @Positive Long userId,
                                    @Valid @RequestBody UserDto.Patch requestBody) {
        User user = UserDto.Patch.patchUser(requestBody);
        user.setUserId(userId);
//        User user = userService.updateUser(mapper.userPatchDtoToUser(requestBody.addUserId(userId)));
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(new SingleResponseDto<>(UserDto.Response.response(user)), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUser(@PathVariable("userId") @Positive Long userId){
        User user = userService.findUser(userId);
        return new ResponseEntity<>(new SingleResponseDto<>(UserDto.Response.response(user)), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity getUsers(@Positive @RequestParam int page,
                                   @Positive @RequestParam(defaultValue = "4") int size){
        Page<User> pageUsers = userService.findUsers(page - 1, size);
        List<User> users = pageUsers.getContent();
        List<UserDto.ListElement> userInfoList = UserDto.getList(users);
        return new ResponseEntity<>(new MultiResponseDto<>(userInfoList, pageUsers),HttpStatus.OK);
    }



    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") @Positive long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

