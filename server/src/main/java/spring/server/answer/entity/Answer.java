package spring.server.answer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import spring.server.question.entity.Question;
import spring.server.answerVote.entity.AnswerVote;
import spring.server.audit.BaseEntity;
import spring.server.user.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Answer")
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private String body;
    private Long votes;

    @Enumerated(EnumType.STRING)
    private AnswerStatus answerStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @JsonIgnore
    @OneToMany(mappedBy = "answer")
    private List<AnswerVote> answerVotes = new ArrayList<>();



    @Builder
    public Answer(String body, Long votes, AnswerStatus answerStatus, User user, Question question) {
        this.body = body;
        this.votes = votes;
        this.answerStatus = answerStatus;
        this.user = user;
        this.question = question;
    }

    public enum AnswerStatus {
        NOT_ACCEPTED("NOT_ACCEPTED"),
        ACCEPTED("ACCEPTED");

        @Getter
        private String status;

        AnswerStatus(String status) {
            this.status = status;
        }
    }



    public void addVote(){
        votes += 1;
    }

    public void subtractVote(){
        votes -= 1;
    }

    public long getUserId() {
        return user.getUserId();
    }
    public String getUserName() {
        return user.getUserName();
    }
    public String getUserImage() {
        return user.getUserImage();
    }
    public long getQuestionId(){
        return question.getQuestionId();
    }
    public Long getAnswerId() { return answerId;}

    public void addAnswer(){
        question.addAnswersCount();
    }


}
