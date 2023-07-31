package spring.server.answer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.server.answer.dto.*;
import spring.server.answer.entity.Answer;
import spring.server.answer.mapper.AnswerMapper;
import spring.server.answer.repository.AnswerRepository;
import spring.server.answer.service.AnswerService;
import spring.server.response.MultiResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping
    public AnswerDto saveAnswer(@RequestBody AnswerPostDto postDto){
        Answer answer = answerService.save(postDto);
        return AnswerDto.answerToAnswerDto(answer);
    }

    @PatchMapping
    public AnswerDto updateAnswer(@RequestBody AnswerPatchDto patchDto){
        Answer answer = answerService.update(patchDto);
        return AnswerDto.answerToAnswerDto(answer);
    }

    @DeleteMapping("/{answerId}")
    public void deleteAnswer(@PathVariable Long answerId){
        answerService.delete(answerId);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity getAnswers(@PathVariable Long questionId,
                                     @RequestParam(defaultValue = "votes") String filter){
        List<AnswerResponseDto> answers = answerService.getAnswers(questionId, filter);

        return ResponseEntity.ok(answers);
    }

    @PostMapping("/accept/{answerId}")
    public void acceptAnswer(@PathVariable Long answerId, @RequestParam Long userId) {
        answerService.acceptAnswer(answerId, userId);
    }

//    @PostMapping("/answers/add-vote/{answerId}")
//    public ResponseEntity addVote(@PathVariable Long answerId,
//                                  @RequestParam Long userId) {
//        answerService.addVote(answerId, userId);
//    }

}
