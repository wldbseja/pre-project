package spring.server.question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;
import spring.server.answer.dto.AnswerResponseDto;
import spring.server.answer.dto.AnswersDto;
import spring.server.answer.entity.Answer;
import spring.server.question.entity.Question;
import spring.server.tag.dto.TagDto;

import spring.server.tag.entity.TagQuestion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDto {
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Post {
        private String title;
        private String content;
        private List<String> tagNames;

//        @Positive
//        private Long userId;
//        public User getUser() {
//            User user = new User();
//            user.setUserId(userId);
//
//            return user;
//        }

        public static Question dtoToQuestion(Post requestBody) {
            return Question.builder()
                    .title(requestBody.getTitle())
                    .content(requestBody.getContent())
                    .answerCount(0)
                    .build();
        }
    }
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Patch {
        private Long questionId;
        private String title;
        private String content;

        public static Question dtoToQuestion(Patch requestBody) {
            return Question.builder()
                    .questionId(requestBody.getQuestionId())
                    .title(requestBody.getTitle())
                    .content(requestBody.getContent())
                    .build();
        }

        public QuestionDto.Patch addQuestionId(Long questionId) {
            Assert.notNull(questionId, "question id must not be null.");
            this.questionId = questionId;
            return this;
        }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }
    }
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {
        private Long questionId;
        private String title;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

        private UserInfo userInfo;
        private AnswersDto answers;
        private int answerCount;
        private int questionViews;
        private int questionVotes;
        private List<TagDto.TagInfo> tagInfos;

//        private Long userId;
//        private int questionViews;
//        private int questionVotes;
//        private int questionAnswers;

        //        @AllArgsConstructor
        @Builder
        @Getter
        private static class UserInfo {
            Long userId;
            String userName;
            String userEmail;

            public UserInfo(Long userId, String userName, String userEmail) {
                this.userId = userId;
                this.userName = userName;
                this.userEmail = userEmail;
            }
        }

        public static Response response(Question updateQuestion) {
            UserInfo userInfo = UserInfo.builder()
                    .userId(updateQuestion.getUserId())
                    .userName(updateQuestion.getUserName())
                    .userEmail(updateQuestion.getUserEmail())
                    .build();

            List<Answer> answerList = updateQuestion.getAnswers() == null ?
                    new ArrayList<>() : updateQuestion.getAnswers();

            List<AnswerResponseDto> answerResponseDtos = answerList.stream()
                    .map(answer -> AnswerResponseDto.AnswerToAnswerResponseDto(answer))
                    .collect(Collectors.toList());

            AnswersDto answersDto = AnswersDto.builder()
                    .answerCount(updateQuestion.getAnswerCount())
                    .answers(answerResponseDtos)
                    .build();

            List<TagQuestion> tagQuestions = updateQuestion.getTagQuestions();
            List<TagDto.TagInfo> tagInfoList = tagQuestions == null
                    ? new ArrayList<>()
                    : tagQuestions.stream()
                    .map(tagQuestion -> TagDto.TagInfo.builder()
                            .tagId(tagQuestion.getTag().getTagId())
                            .tagName(tagQuestion.getTag().getTagName())
                            .build()
                    )
                    .collect(Collectors.toList());

            return Response.builder()
                    .questionId(updateQuestion.getQuestionId())
                    .title(updateQuestion.getTitle())
                    .content(updateQuestion.getContent())
                    .createdAt(updateQuestion.getCreatedAt())
                    .modifiedAt(updateQuestion.getModifiedAt())
                    .userInfo(userInfo)
                    .answerCount(updateQuestion.getAnswerCount())
                    .questionViews(updateQuestion.getQuestionViews())
                    .questionVotes(updateQuestion.getQuestionVotes())
                    .answers(answersDto)
                    .tagInfos(tagInfoList)
                    .build();
        }
    }
    @Getter
    @Setter
    @AllArgsConstructor
    public static class AnswerResponse<T>{
        private List<T> data;
        int answersCount;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ListElement {
        private Long questionId;
        private String title;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        //        private List<TagQuestion> tags;
        private int votes;
        private int answerCount;
        private Response.UserInfo userInfo;
        private List<TagDto.TagInfo> tagInfo;
    }
    public static List<QuestionDto.ListElement> getList(List<Question> questions) {
        if (questions == null){
            return new ArrayList<>();
        }

        return questions.stream()
                .map(question -> ListElement.builder()
                        .questionId(question.getQuestionId())
                        .title(question.getTitle())
                        .content(question.getContent())
                        .createdAt(question.getCreatedAt())
                        .modifiedAt(question.getModifiedAt())
                        .votes(question.getVotes())
                        .answerCount(question.getAnswerCount())
                        .userInfo(Response.UserInfo.builder()
                                .userId(question.getUserId())
                                .userName(question.getUserName())
                                .userEmail(question.getUserEmail())
                                .build()
                        )
                        .tagInfo(
                                question.getTagQuestions().stream()
                                        .map(tq ->TagDto.TagInfo.builder()
                                                .tagId(tq.getTag().getTagId())
                                                .tagName(tq.getTag().getTagName())
                                                .build()
                                        )
                                        .collect(Collectors.toList())
                        )
                        .build()
                )
                .collect(Collectors.toList());
    }


}
