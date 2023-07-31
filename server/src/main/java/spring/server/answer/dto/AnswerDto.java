package spring.server.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.server.answer.entity.Answer;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDto {
    private Long answerId;
    private String body;
    private String answerStatus;
    private Long votes;
    private Long questionId;
    private Long userId;


    public static AnswerDto answerToAnswerDto(Answer answer){
        return new AnswerDto(
                answer.getAnswerId(),
                answer.getBody(),
                answer.getAnswerStatus().name(),
                answer.getVotes(),
                answer.getQuestion().getQuestionId(),
                answer.getUser().getUserId()
        );
    }
}
