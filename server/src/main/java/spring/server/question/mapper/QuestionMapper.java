package spring.server.question.mapper;

import org.mapstruct.Mapper;
import spring.server.question.dto.QuestionDto;
import spring.server.question.entity.Question;


import java.util.List;

//@Mapper(componentModel = "spring")
public interface QuestionMapper {
    Question questionPostDtoToQuestion(QuestionDto.Post postQuestion);
    Question questionPatchDtoToQuestion(QuestionDto.Patch patchQuestion);
    QuestionDto.Response questionToResponseDto(Question question);
    List<QuestionDto.Response> questionsToResponseDtos(List<Question> questions);



}