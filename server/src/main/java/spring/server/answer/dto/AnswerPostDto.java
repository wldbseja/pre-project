package spring.server.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerPostDto {
    private Long userId;
    private Long questionId; //questionId
    private String body;
}
