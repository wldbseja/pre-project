package spring.server.question.service;



import org.springframework.data.domain.*;
import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.domain.Specification;
import spring.server.advice.BusinessLogicException;
import spring.server.advice.ExceptionCode;
import spring.server.answer.repository.AnswerRepository;
import spring.server.question.entity.Question;
import spring.server.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.server.question.search.QuestionSpec;
import spring.server.tag.entity.Tag;
import spring.server.tag.entity.TagQuestion;
import spring.server.tag.repository.TagQuestionRepository;
import spring.server.tag.repository.TagRepository;
import spring.server.user.entity.User;
import spring.server.user.repository.UserRepository;
import spring.server.user.service.UserService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final TagQuestionRepository tagQuestionRepository;

    private static final int SIZE = 6;



    public Question createdQuestion(Long userId, Question question, List<String> tagNames){

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new BusinessLogicException(ExceptionCode.USER_NOT_FOUND);
        }
        question.setUser(optionalUser.get());

        List<Tag> allTags = tagRepository.findAll();

        List<Tag> existTags = allTags.stream()
                .filter(tag -> tagNames.contains(tag.getTagName()))
                .collect(Collectors.toList());

        existTags.stream()
                .forEach(tag -> Tag.addMemtionCount(tag));

        List<TagQuestion> tagQuestions = existTags.stream()
                .map(tag -> {
                    TagQuestion tagQuestion = new TagQuestion();
                    tagQuestion.setTag(tag);
                    tagQuestion.setUser(optionalUser.get());
                    tagQuestion.setQuestion(question);
//                    return tagQuestionRepository.save(tagQuestion);
                    return tagQuestion;
                })
                .collect(Collectors.toList());

        question.setTagQuestions(tagQuestions);

        return questionRepository.save(question);
    }


    //질문 수정
    public Question updateQuestion(Long userId, Question question){
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());
        if (!findQuestion.getUser().getUserId().equals(userId)){
            throw new BusinessLogicException(ExceptionCode.QUESTION_USER_NOT_MATCH);
        }

        Optional.ofNullable(question.getTitle())
                .ifPresent(questionTitle -> findQuestion.setTitle(questionTitle));
        //질문 문제 수정
        Optional.ofNullable(question.getContent())
                .ifPresent(questionContent -> findQuestion.setContent(questionContent));

        return questionRepository.save(findQuestion);
    }

    //질문 조회(1개만) - 즉 선택
    public Question findQuestion(Long questionId){
        Question question = findVerifiedQuestion(questionId);
        question.setQuestionViews((question.getQuestionViews() +1)); //조회수 +1
        return question;
    }


    // todo 필터링 확인
    @Transactional(readOnly = true)
    public Page<Question> findQuestions(int page, int size, String tab) {
        Pageable pageable;
        if (tab.equals("newest")) {
            pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        } else if (tab.equals("answered")) {
            pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "answerCount"));
        } else if (tab.equals("unanswered")) {
            pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        } else {
            throw new IllegalArgumentException("Invalid sort parameter");
        }

        Page<Question> questionPage;
        if (tab.equals("unanswered")) {
            questionPage = questionRepository.findAllByAnswerCount(0, pageable);
        } else if (tab.equals("answered")) {
            questionPage = questionRepository.findAllQuestionsAnswered(pageable);
        } else {
            questionPage = questionRepository.findAll(pageable);
        }
        return questionPage;
    }


    //검색
    @Transactional(readOnly = true)
    public Page<Question> searchQuestions(String type, String keyword, int page) {
        Pageable pageable = PageRequest.of(page, SIZE); // 예시로 페이지 정보를 초기화합니다. 적절한 값을 설정해야 합니다.

        Specification spec = createSpec(type, keyword);
        return questionRepository.findAll(spec, pageable);
    }

    private Specification createSpec(String type, String keyword) {
        if (type.equals("tag")) {
            return QuestionSpec.tagLike(keyword);
        }
        return QuestionSpec.like(type, keyword);
    }







    public void deleteQuestion(Long questionId, Long userId) {
        Question question = findVerifiedQuestion(questionId);
        User user = userService.findUserById(userId);

        if (!question.getUser().equals(user)) {
            throw new BusinessLogicException(ExceptionCode.UN_AUTHORIZED);
        }

        questionRepository.delete(question);
    }

//    public void deleteQuestion(Long questionId){
//        Question findquestion = findVerifiedQuestion(questionId);
//        List<TagQuestion> tagQuestions = tagQuestionRepository.findTagQuestions(questionId);
//        tagQuestions.stream()
//                .forEach(tagQuestion -> {
//                    Tag.subtractMemtionCount(tagQuestion.getTag());
//                });
//
//        questionRepository.delete(findquestion);
//    }



    //해당 게시글이 존재하는지 체크 1
    public Question findVerifiedQuestion(Long questionId){
        Optional<Question> optionalQuestion = questionRepository.findByQuestionId(questionId);
        if (optionalQuestion.isEmpty()){
            throw new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND);
        }
        return optionalQuestion.get();
    }

    //해당 게시글이 존재하는지 체크 3
//    public Question findVerifiedQuestion(Question question, Long userId){
//        Long questionId = question.getQuestionId();
//        if (!userId.equals(questionId)){
//            throw new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND);
//        }
//        if (questionId == null){
//            throw new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND);
//        }
//        Optional<Question> optionalQuestion =
//                questionRepository.findByQuestionId(questionId);
//
//        return optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
//    }



}

