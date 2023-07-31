package spring.server.answer.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.server.answer.dto.AnswerUserInfo;
import spring.server.answer.entity.Answer;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerSortResponse {
    private Long answerId;
    private String content;
    private Answer.AnswerStatus answerStatus;
    private Long answerVotes;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private Long userId;
    private String userName;
    private String userImage;
}
