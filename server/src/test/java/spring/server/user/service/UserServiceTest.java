package spring.server.user.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.server.advice.BusinessLogicException;
import spring.server.user.entity.User;
import spring.server.user.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//@Transactional
class UserServiceTest {
//    @Autowired UserRepository userRepository;
//    @Autowired UserService userService;

//    @AfterEach
//    void delete(){
//        userRepository.deleteAll();
//    }

//    @Test
//    @DisplayName("유저 저장")
//    void saveUser() {
//        //given
//        User user = new User();
//        user.setUserEmail("myoungin@gmail.com");
//        user.setUserPassword("1234");
//        user.setUserName("myoungin");
//
//        //when
//        User saveUser = userService.createUser(user);
//
//        //then
//        assertEquals(saveUser.getUserId(), user.getUserId());
//        assertEquals(saveUser.getUserPassword(), user.getUserPassword());
//        assertEquals(saveUser.getUserName(), user.getUserName());
//        assertEquals(saveUser.getRoles().get(0), "USER");
//    }
//
//    @Test
//    @DisplayName("email 중복시 에러 처리한다.")
//    void duplicateSaveUser(){
//        //given
//        User user = new User();
//        user.setUserEmail("myoungin@gmail.com");
//        user.setUserPassword("1234");
//        user.setUserName("myoungin");
//
//        User user2 = new User();
//        user2.setUserEmail("myoungin@gmail.com");
//        user2.setUserPassword("1234");
//        user2.setUserName("myoungin2");
//
//        //when
//        userService.createUser(user);
//
//        //then
//        Assertions.assertThatThrownBy(
//                () -> userService.createUser(user2)
//        ).isInstanceOf(BusinessLogicException.class);
//    }
//
//    @Test
//    @DisplayName("유저 정보 변경")
//    void updateUser() {
//        //given
//        User user = new User();
//        user.setUserEmail("myoungin@gmail.com");
//        user.setUserPassword("1234");
//        user.setUserName("myoungin");
//        User saveUser = userService.createUser(user);
////        System.out.println(saveUser.getUserId());
//
//        //when
//        User user2 = new User();
//        user2.setUserId(saveUser.getUserId());
//        user2.setUserEmail("myoungin2@gmail.com");
//        user2.setUserPassword("12345");
//        user2.setUserName("myoungin2");
//        User updateUser = userService.updateUser(user2);
//        User getUser = userRepository.findById(updateUser.getUserId()).get();
//
//        //then
//        assertEquals(updateUser.getUserId(), getUser.getUserId());
//        assertEquals(updateUser.getUserPassword(), getUser.getUserPassword());
//        assertEquals(updateUser.getUserName(), getUser.getUserName());
//    }
//
//    @Test
//    @DisplayName("유저 삭제")
//    void deleteUser(){
//        //given
//        User user = new User();
//        user.setUserEmail("myoungin@gmail.com");
//        user.setUserPassword("1234");
//        user.setUserName("myoungin");
//        User savedUser = userRepository.save(user);
//
//        //when
//        userService.deleteUser(savedUser.getUserId());
//
//        //then
//        Assertions.assertThatThrownBy(
//                () -> userService.findUser(savedUser.getUserId()))
//                .isInstanceOf(BusinessLogicException.class);
//    }
}