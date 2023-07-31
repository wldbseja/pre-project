package spring.server.questionVote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring.server.questionVote.dto.QuestionVoteDto;
import spring.server.questionVote.entity.QuestionVote;

@Mapper(componentModel = "spring")
public interface QuestionVoteMapper {
//    @Mapping(source = "questionId", target = "question.questionId")
    QuestionVote questionVotePostQuestionVote(QuestionVoteDto.Post postQuestionVote);

//    @Mapping(source = "question.questionId", target = "questionId")
    QuestionVoteDto.Response questionVoteToResponseQuestionVote(QuestionVote questionVote);
}