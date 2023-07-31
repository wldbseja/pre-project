package spring.server.answer.mapper;

import org.mapstruct.Mapper;
import spring.server.answer.dto.AnswerPatchDto;
import spring.server.answer.dto.AnswerPostDto;
import spring.server.answer.dto.AnswerResponseDto;
import spring.server.answer.entity.Answer;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
    Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto);
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);
    List<AnswerResponseDto> answersToResponseAnswerDtos(List<Answer> answers);
}
