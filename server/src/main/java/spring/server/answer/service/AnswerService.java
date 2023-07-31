package spring.server.answer.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import spring.server.advice.BusinessLogicException;
import spring.server.advice.ExceptionCode;
import spring.server.answer.dto.AnswerPatchDto;
import spring.server.answer.dto.AnswerPostDto;
import spring.server.answer.dto.AnswerResponseDto;
import spring.server.answer.entity.Answer;

import spring.server.answer.repository.AnswerRepository;
import spring.server.question.entity.Question;
import spring.server.question.repository.QuestionRepository;
import spring.server.user.entity.User;
import spring.server.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository, UserRepository userRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }


    public List<AnswerResponseDto> getAnswers(Long questionId, String filter) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.ASC, "answerStatus"));
        if (filter.equals("votes")){
            orders.add(new Order(Direction.DESC, filter));
        } else if (filter.equals("createdAt")) {
            orders.add(new Order(Direction.ASC, filter));
        } else if (filter.equals("modifiedAt")) {
            orders.add(new Order(Direction.DESC, filter));
        } else {
            throw new BusinessLogicException(ExceptionCode.ANSWER_FILTER_NOT_FOUND);
        }

        List<Answer> answers = answerRepository.findAllSorting(questionId, Sort.by(orders));
        List<AnswerResponseDto> answerResponseDtos = answers.stream()
                .map(answer -> AnswerResponseDto.AnswerToAnswerResponseDto(answer))
                .collect(Collectors.toList());

        return answerResponseDtos;
    }

    public Answer save(AnswerPostDto postDto) {
        Optional<Question> optionalQuestion = questionRepository.findById(postDto.getQuestionId());
        Optional<User> optionalUser = userRepository.findById(postDto.getUserId());
        verifyIDs(optionalQuestion, optionalUser);

        Answer answer = Answer.builder()
                .body(postDto.getBody())
                .votes(0L)
                .answerStatus(Answer.AnswerStatus.NOT_ACCEPTED)
                .question(optionalQuestion.get())
                .user(optionalUser.get())
                .build();
        answer.addAnswer();
        return answerRepository.save(answer);
    }

    private void verifyIDs(Optional<Question> optionalQuestion, Optional<User> optionalUser) {
        if (optionalQuestion.isEmpty()){
            throw new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND);
        }
        if (optionalUser.isEmpty()){
            throw new BusinessLogicException(ExceptionCode.USER_NOT_FOUND);
        }
    }

    public Answer update(AnswerPatchDto patchDto) {
        Optional<Answer> optionalAnswer = answerRepository.findById(patchDto.getAnswerId());
        verifyUserAnswer(optionalAnswer, patchDto.getUserId());

        Answer findAnswer = optionalAnswer.get();
        findAnswer.setBody(patchDto.getBody());
        Answer updatedAnswer = answerRepository.save(findAnswer);
        return updatedAnswer;
    }

    private void verifyUserAnswer(Optional<Answer> optionalAnswer, Long userId) {
        if (optionalAnswer.isEmpty()){
            throw new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND);
        }
        if (!optionalAnswer.get().getUser().getUserId().equals(userId)){
            throw new BusinessLogicException(ExceptionCode.CANNOT_UPDATE_ANSWER);
        }
    }

    public void delete(Long answerId) {
        Answer answer = findVerifiedAnswer(answerId);
        Question question = questionRepository.findById(answer.getQuestionId()).get();
        question.subtractAnswersCount();
        answerRepository.deleteById(answerId);
    }

    public void acceptAnswer(Long answerId, Long userId){
        Answer answer = findVerifiedAnswer(answerId);
        if (answer.getAnswerStatus().equals(Answer.AnswerStatus.ACCEPTED)){
            throw new BusinessLogicException(ExceptionCode.ANSWER_ALREADY_ACCEPTED);
        }
        if (answer.getQuestion().getUser().getUserId() == userId){
            answer.setAnswerStatus(Answer.AnswerStatus.ACCEPTED);
            answerRepository.save(answer);
        }
    }

    public Answer findVerifiedAnswer(long answerId) {  // 해당 답변글의 존재 유무 체크
        Answer answer = answerRepository.findByAnswerId(answerId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return answer;
    }


}
