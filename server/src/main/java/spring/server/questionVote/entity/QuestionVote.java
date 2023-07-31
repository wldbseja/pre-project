package spring.server.questionVote.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import spring.server.question.entity.Question;
import spring.server.audit.BaseEntity;
import spring.server.user.entity.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "QUESTIONS_VOTE")
public class QuestionVote extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionVoteId;

    @Column(nullable = false)
    private Boolean questionVoteStatus;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID") //외래키를 매핑할 때 사용
    private Question question;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public void setQuestion(Question question) {
        this.question = question;
        if(!this.question.getQuestionVote().contains(this)){
            this.question.getQuestionVote().add(this);
        }
    }
    public void setUser(User user) {
        this.user = user;
        if (!this.user.getQuestionVotes().contains(this)) {
            this.question.getQuestionVote().add(this);
        }
    }





}