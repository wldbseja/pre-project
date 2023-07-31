package spring.server.questionVote.dto;

import lombok.*;
import spring.server.question.entity.Question;
import spring.server.questionVote.entity.QuestionVote;
import spring.server.user.entity.User;





public class QuestionVoteDto {

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Post {
        private Boolean questionVoteStatus;
        private Long userId;
        private Long questionId;

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }

        public static Question getQuestion(Long questionId) {
            Question question = new Question();
            question.setQuestionId(questionId);
            return question;
        }

        public static User getUser(Long userId) {
            User user = new User();
            user.setUserId(userId);
            return user;
        }

        public static QuestionVote dtoToQuestionVote(QuestionVoteDto.Post questionVoteDto) {
            QuestionVote questionVote = new QuestionVote();
            questionVote.setQuestionVoteStatus(questionVoteDto.getQuestionVoteStatus());
            questionVote.setQuestion(getQuestion(questionVoteDto.getQuestionId()));
            questionVote.setUser(getUser(questionVoteDto.getUserId()));
            return questionVote;
        }

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch{
        private Long userId;
        private Long questionId;
        private Boolean questionVoteStatus;

        public static QuestionVote dtoToQuestionVote(Patch requestBody) {
            return QuestionVote.builder()
                    .questionVoteStatus(requestBody.getQuestionVoteStatus())
                    .build();
        }
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class Response {
        private Long questionVoteId;
        private boolean questionVoteStatus;
        private Long questionId;
        private Long userId;


        public static Response response(QuestionVote updateQuestionVote) {
            return Response.builder()
                    .questionVoteId(updateQuestionVote.getQuestionVoteId())
                    .questionVoteStatus(updateQuestionVote.getQuestionVoteStatus())
                    .questionId(updateQuestionVote.getQuestion().getQuestionId())
                    .userId(updateQuestionVote.getUser().getUserId())
                    .build();
        }
    }


}