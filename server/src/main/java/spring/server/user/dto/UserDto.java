package spring.server.user.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import spring.server.question.dto.QuestionDto;
import spring.server.user.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserDto {

    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank
        private String userName;

        @NotNull
        @Email
        private String userEmail;

        @NotBlank
        private String userPassword;


        private String userImage;


//        public static User dtoToUser(Post requestBody) {
//            return User.builder()
//                    .userName(requestBody.getUserName())
//                    .userEmail(requestBody.getUserEmail())
//                    .userPassword(requestBody.getUserPassword())
//                    .build();
//        }

        public static User dtoToUser(Post requestBody) {
            return new User(requestBody.getUserName(),
                    requestBody.getUserEmail(),
                    requestBody.getUserPassword());
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        private String userName;
        private String userPassword;
        private String userImage;
        private User.UserStatus userStatus;

//        public UserDto.Patch addUserId(long userId) {
//            Assert.notNull(userId, "user id must not be null.");
//            this.userId = userId;
//            return this;
//        }

        public static User patchUser(Patch requestBody){
            return User.builder()
                    .userName(requestBody.getUserName())
                    .userPassword(requestBody.getUserPassword())
                    .userImage(requestBody.getUserImage())
                    .userStatus(requestBody.getUserStatus())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private long userId;
        private String userEmail;
        private String userName;
        private String userImage;
//        private String userStatus;
        private List<QuestionDto.ListElement> questions;

        /*
        TODO : user 안의 질문, 답변 카드형식으로 반환
         */
        public static Response response(User user) {
            return Response.builder()
                    .userId(user.getUserId())
                    .userName(user.getUserName())
                    .userEmail(user.getUserEmail())
                    .userImage(user.getUserImage())
                    .questions(QuestionDto.getList(user.getQuestions()))
                    .build();
        }
    }
    @Getter
    @Builder
    @AllArgsConstructor
    public static class ListElement {
        private Long id;
        private String userImage;
        private String userName;
        private String userEmail;
    }
    public static List<ListElement> getList(List<User> users) {
        return users.stream()
                .map(user -> ListElement.builder()
                            .id(user.getUserId())
                            .userEmail(user.getUserEmail())
                            .userImage(user.getUserImage())
                            .userName(user.getUserName())
                            .build()
                )
                .collect(Collectors.toList());
    }
}
