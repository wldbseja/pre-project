package spring.server.questionVote.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.server.questionVote.dto.QuestionVoteDto;
import spring.server.questionVote.entity.QuestionVote;
import spring.server.questionVote.mapper.QuestionVoteMapper;
import spring.server.questionVote.service.QuestionVoteService;
import spring.server.utils.UriCreator;

import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@CrossOrigin
@RequestMapping("/questions")
public class QuestionVoteController {
    private final String DEFAULT_URL = "/questions";
    private final QuestionVoteService questionVoteService;
    private final QuestionVoteMapper mapper;

    public QuestionVoteController(QuestionVoteService questionVoteService, QuestionVoteMapper mapper) {
        this.questionVoteService = questionVoteService;
        this.mapper = mapper;
    }

    @PostMapping("/{question-id}/question_Vote")
    public ResponseEntity postQuestionVote(@PathVariable("question-id") long questionId,
                                           @RequestBody QuestionVoteDto.Post postQuestionVote) {

        postQuestionVote.setQuestionId(questionId);
        postQuestionVote.setUserId(postQuestionVote.getUserId());

        QuestionVote questionVote = questionVoteService.creteQuestionVote(mapper.questionVotePostQuestionVote(postQuestionVote));

        long id = questionVote.getQuestionVoteId();

        URI location = UriCreator.createUri(DEFAULT_URL, questionId, id);

        QuestionVoteDto.Response response = mapper.questionVoteToResponseQuestionVote(questionVote);

        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/{question-vote-id}/question-vote")
    public ResponseEntity deleteQuestionVote(@PathVariable("question-vote-id") @Positive long questionVoteId){
        questionVoteService.deleteQuestionVote(questionVoteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
