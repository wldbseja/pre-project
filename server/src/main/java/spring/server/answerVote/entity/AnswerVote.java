package spring.server.answerVote.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import spring.server.answer.entity.Answer;
import spring.server.audit.BaseEntity;
import spring.server.user.entity.User;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ANSWERS_VOTE")
public class AnswerVote extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerVoteId;

    @Column(nullable = false)
    private Boolean answerVoteStatus;  // defult == false

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public void setAnswer(Answer answer) {
        this.answer = answer;
        if (!this.answer.getAnswerVotes().contains(this)) {
            this.answer.getAnswerVotes().add(this);
        }
    }
    public void setUser(User user) {
        this.user = user;
        if (!this.user.getAnswerVotes().contains(this)) {
            this.user.getAnswerVotes().add(this);
        }
    }

}