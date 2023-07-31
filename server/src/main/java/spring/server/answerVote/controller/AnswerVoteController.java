package spring.server.answerVote.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.server.answerVote.dto.AnswerVoteDto;
import spring.server.answerVote.entity.AnswerVote;
import spring.server.answerVote.mapper.AnswerVoteMapper;
import spring.server.answerVote.service.AnswerVoteService;
import spring.server.utils.UriCreator;

import javax.validation.constraints.Positive;
import java.net.URI;

@CrossOrigin
//@RestController
@RequestMapping("/answers")
public class AnswerVoteController {
    private final static String ANSWER_VOTE_DEFAULT_URL = "/answers";
    private final AnswerVoteService answerVoteService;
    private final AnswerVoteMapper mapper;

    public AnswerVoteController(AnswerVoteService answerVoteService, AnswerVoteMapper mapper) {
        this.answerVoteService = answerVoteService;
        this.mapper = mapper;
    }

    @PostMapping("/{answer-id}/answer-vote")
    public ResponseEntity postAnswerVote(@PathVariable("answer-id") Long answerId,
                                         @RequestBody AnswerVoteDto.Post votePost) {
        votePost.setAnswerId(answerId);
        AnswerVote answerVote = AnswerVoteDto.Post.toAnswerVote(votePost);
//        AnswerVote answerVote = answerVoteService.createAnswerVote(mapper.AnswerVotePostAnswerVote(votePost));
        long answerVoteId = answerVote.getAnswerVoteId();
        URI location = UriCreator.createUri(ANSWER_VOTE_DEFAULT_URL, answerId, answerVoteId);

        AnswerVoteDto.Response response = mapper.answerVoteToResponseAnswerVote(answerVote);

        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/{answer-vote-id}/answer-vote")
    public ResponseEntity deleteAnswerVote(@PathVariable("answer-vote-id") Long answerVoteId){
        answerVoteService.deleteAnswerVote(answerVoteId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}