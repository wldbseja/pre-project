package spring.server.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.server.answer.entity.Answer;
import spring.server.answer.repository.AnswerSortResponse;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponseDto {
    private Long id;
    private String content;
    private String answerStatus;
    private Long answerVotes;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private AnswerUserInfo answerUserInfo;


    public static AnswerResponseDto AnswerToAnswerResponseDto(Answer answer){
        return new AnswerResponseDto(
                answer.getAnswerId(),
                answer.getBody(),
                answer.getAnswerStatus().name(),
                answer.getVotes(),
                answer.getCreatedAt(),
                answer.getModifiedAt(),
                new AnswerUserInfo(
                        answer.getUser().getUserId(),
                        answer.getUser().getUserName(),
                        answer.getUser().getUserImage()
                )
        );
    }

    public static AnswerResponseDto sortResponseToDto(AnswerSortResponse answerSortResponse){
        return new AnswerResponseDto(
                answerSortResponse.getAnswerId(),
                answerSortResponse.getContent(),
                answerSortResponse.getAnswerStatus().toString(),
                answerSortResponse.getAnswerVotes(),
                answerSortResponse.getCreatedAt(),
                answerSortResponse.getModifiedAt(),
                new AnswerUserInfo(
                        answerSortResponse.getUserId(),
                        answerSortResponse.getUserName(),
                        answerSortResponse.getUserImage()
                )
        );
    }
}
