package spring.server.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.server.advice.BusinessLogicException;
import spring.server.advice.ExceptionCode;
import spring.server.answer.entity.Answer;
import spring.server.answerVote.entity.AnswerVote;
import spring.server.question.entity.Question;
import spring.server.questionVote.entity.QuestionVote;
import spring.server.tag.entity.TagQuestion;
import spring.server.utils.CustomBeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private String userImage = "기본 이미지 URL";

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus = UserStatus.USER_EXIST;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();



    public enum UserStatus {
        USER_NOT_EXIST("존재하지 않는 회원"),
        USER_EXIST("활동 회원");

        @Getter
        private String status;

        UserStatus(String status) {
            this.status = status;
        }
    }


    public static void isExistEmail(Optional<User> targetMember) {
        if(targetMember.isPresent())
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
    }


    public User changeUserInfo(User sourceUser, CustomBeanUtils<User> beanUtils) {
        return beanUtils.copyNonNullProperties(sourceUser, this);
    }


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Answer> answers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<AnswerVote> answerVotes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Question> questions = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<QuestionVote> questionVotes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<TagQuestion> tagQuestions = new ArrayList<>();


//    @Builder
//    public User(Long userId, String userName, String userEmail, String userPassword, String userImage, UserStatus userStatus) {
//        this.userId = userId;
//        this.userName = userName;
//        this.userEmail = userEmail;
//        this.userPassword = userPassword;
//        this.userImage = userImage;
//        this.userStatus = userStatus;
//    }


    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Builder
    public User(Long userId, String userName, String userEmail, String userPassword, String userImage, UserStatus userStatus, List<String> roles, List<Answer> answers, List<AnswerVote> answerVotes, List<Question> questions, List<QuestionVote> questionVotes, List<TagQuestion> tagQuestions) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userImage = userImage;
        this.userStatus = userStatus;
        this.roles = roles;
        this.answers = answers;
        this.answerVotes = answerVotes;
        this.questions = questions;
        this.questionVotes = questionVotes;
        this.tagQuestions = tagQuestions;
    }
}
