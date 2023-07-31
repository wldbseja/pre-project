package spring.server.answerVote.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring.server.answerVote.dto.AnswerVoteDto;
import spring.server.answerVote.entity.AnswerVote;

@Mapper(componentModel = "spring")
public interface AnswerVoteMapper {
//    @Mapping(source = "answerId", target = "answer.answerId")
    AnswerVote AnswerVotePostAnswerVote(AnswerVoteDto.Post votePost);

//    @Mapping(source = "answer.answerId", target = "answerId")
    AnswerVoteDto.Response answerVoteToResponseAnswerVote(AnswerVote answerVote);
}