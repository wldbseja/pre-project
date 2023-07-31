package spring.server.user.controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import spring.server.user.dto.UserDto;
import spring.server.user.entity.User;
import spring.server.user.mapper.UserMapper;
import spring.server.user.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@WebMvcTest(controllers = UserController.class)
//@AutoConfigureMockMvc
class UserControllerTest {

//    @Test
//    @DisplayName("유저 Post")
    void postUser() throws Exception {
        // given  (1)
//        UserDto.Post post = new UserDto.Post(
//                "myoungin",
//                "myoungin@gmail.com",
//                "010-1234-5678");
//        User user = mapper.userPostDtoToUser(post);
//        user.setUserId(1L);
//
//        given(userService.createUser(Mockito.any(User.class)))
//                .willReturn(user);
//
//        String content = gson.toJson(post); // (2)
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(                        // (3)
//                        post("/users")  // (4)
//                                .accept(MediaType.APPLICATION_JSON) // (5)
//                                .contentType(MediaType.APPLICATION_JSON) // (6)
//                                .content(content)
//                );
//
//        // then
//        actions
//                .andExpect(status().isOk()) // (8)
//                .andExpect(jsonPath("$.userEmail").value(user.getUserEmail()));
    }


}