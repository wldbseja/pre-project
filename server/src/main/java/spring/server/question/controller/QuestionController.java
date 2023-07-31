package spring.server.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.server.answer.dto.AnswerDto;
import spring.server.answer.dto.AnswerPatchDto;
import spring.server.answer.dto.AnswerPostDto;
import spring.server.answer.dto.AnswerResponseDto;
import spring.server.answer.entity.Answer;
import spring.server.question.dto.QuestionDto;
import spring.server.question.entity.Question;
import spring.server.question.mapper.QuestionMapper;
import spring.server.question.service.QuestionService;
import spring.server.response.MultiResponseDto;
import spring.server.response.SingleResponseDto;
import spring.server.user.dto.UserDto;
import spring.server.user.entity.User;
import spring.server.utils.UriCreator;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor

public class QuestionController {
    private final static String QUESTION_DEFAULT_URL = "/questions";
    private final QuestionService questionService;

    @PostMapping("/ask")
    public ResponseEntity postQuestion(@RequestParam Long userId,
                                       @Valid @RequestBody QuestionDto.Post requestBody){
        Question question = QuestionDto.Post.dtoToQuestion(requestBody);
        List<String> tagNames = requestBody.getTagNames();
        Question createdQuestion = questionService.createdQuestion(userId, question, tagNames);
//        URI location = UriCreator.createUri(QUESTION_DEFAULT_URL, createdQuestion.getQuestionId());
        return new ResponseEntity<>(QuestionDto.Response.response(createdQuestion), HttpStatus.CREATED);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity patchQuestion(@PathVariable("userId") Long userId,
                                        @Valid @RequestBody QuestionDto.Patch requestBody) {

        Question question = QuestionDto.Patch.dtoToQuestion(requestBody);
        Question updateQuestion = questionService.updateQuestion(userId, question);
        return new ResponseEntity<>(QuestionDto.Response.response(updateQuestion), HttpStatus.OK);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") @Positive Long questionId,
                                            @RequestParam("userId") @Positive Long userId) {
        questionService.deleteQuestion(questionId,userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{questionId}")
    public ResponseEntity getQuestion(@PathVariable("questionId") @Positive Long questionId){
        Question question = questionService.findQuestion(questionId);
        return new ResponseEntity<>(QuestionDto.Response.response(question), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getQuestions(@Positive @RequestParam int page,
                                       @Positive @RequestParam(defaultValue = "6") int size,
                                       @RequestParam(defaultValue = "newest") String tab) {
        Page<Question> pageQuestions = questionService.findQuestions(page - 1, size, tab);
        List<Question> questions = pageQuestions.getContent();

        return new ResponseEntity<>(new MultiResponseDto<>(QuestionDto.getList(questions), pageQuestions), HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity getSearch(@RequestParam String type,
                                    @RequestParam String keyword,
                                    @Positive @RequestParam(defaultValue = "1") int page) {
        Page<Question> pageQuestions = questionService.searchQuestions(type, keyword, page-1);
        List<Question> questions = pageQuestions.getContent();
        return new ResponseEntity<>(new MultiResponseDto<>(QuestionDto.getList(questions), pageQuestions), HttpStatus.OK);
    }

}



