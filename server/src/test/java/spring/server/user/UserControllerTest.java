package spring.server.user;

import spring.server.user.dto.UserDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



//@SpringBootTest
//@AutoConfigureMockMvc
public class UserControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    public void postUserTest() throws Exception {
//        // given 테스트용 request body 생성
//        UserDto.Post post = new UserDto.Post("kimsohee","ba@gmail.com","1111","path");
//        String postContent = gson.toJson(post);
//
//        ResultActions postActions = mockMvc.perform(
//                post("/users")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(postContent)
//        );
//
//        // when MockMvc 객체로 테스트 대상 Controller 호출
//        String location = postActions.andReturn().getResponse().getHeader("Location");
//        // then Controller 핸들러 메서드에서 응답으로 수신한 HTTP Status 및 response body 검증
//        mockMvc.perform(
//                        get(location)
//                                .accept(MediaType.APPLICATION_JSON)
//                )
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.userName").value(post.getUserName()))
//                .andExpect(jsonPath("$.data.userEmail").value(post.getUserEmail()))
//                .andExpect(jsonPath("$.data.userPassword").value(post.getUserPassword()))
//                .andExpect(jsonPath("$.data.userImage").value(post.getUserImage()));
//
//    }
}